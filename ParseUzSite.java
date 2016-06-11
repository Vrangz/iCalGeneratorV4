package iCalGenerator;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class ParseUzSite {
	ArrayList<String> startHourArray = new ArrayList<>();
	ArrayList<String> endHourArray = new ArrayList<>();
	ArrayList<String> name = new ArrayList<>();
	String url = null;
	
	public ParseUzSite(String url) throws IOException {
		setUrl(url);
		parseUz();
	}
	
	public void parseUz() throws IOException {
		try {
			Document uzPlan = Jsoup.connect(url).get();
			Elements days = uzPlan.select("p");
			Document uzTerm = Jsoup.connect("http://plan.uz.zgora.pl/" + 
											days.get(0).parent().parent().nextElementSibling().child(7).child(0).attr("href")).get();
			String startHour;
			String endHour;
			Element temp;
			String date;
			Element dates;
			String helpDate;
			int k;
			for(int i = 0; i < days.size(); i++) {
				k = 1;
				temp = days.get(i).parent().parent();
				while(true) {
					temp = temp.nextElementSibling();
					try {
						startHour = temp.child(1).text();
					}
					catch(Exception e) {	
						break;
					}
					endHour = temp.child(2).text();
					date = temp.child(7).text();
					date = date.substring(0, date.length()-1);
					while(true) {
						try {
							dates = uzTerm.select("table").get(1).child(0).child(1);;
							helpDate = uzTerm.select("table").get(k).parent().previousElementSibling().text();
						}
						catch(Exception e) {
							if(date.charAt(0) == '0' || date.charAt(0) == '1' ||
									date.charAt(0) == '2' || date.charAt(0) == '3' ) {
								try {
									date = date.substring(0,10);
									}
									catch(Exception e2) {}
									startHourArray.add(date + " " + startHour);
									endHourArray.add(date + " " + endHour);
									name.add(temp.child(3).text());
							}
							k = 1;
							break;
							
						}
						k++;
						if(helpDate.substring(0,13).equals("Terminy zajêæ")) {
							helpDate = helpDate.substring(14, helpDate.indexOf(" - "));
						}
						else {
							helpDate = helpDate.substring(0, helpDate.indexOf(" - "));
						}
						if(date.equals(helpDate)) {
							while(true) {
								try {

									if(dates.child(2).text().equals(days.get(i).text())) {
										startHourArray.add(dates.child(1).text() + " " + 
													   	startHour);
										endHourArray.add(dates.child(1).text() + " " + 
														 endHour);
										name.add(temp.child(3).text());	
									}
									dates = dates.nextElementSibling();
								}
								catch(Exception e) {
									break;}
							}
						}	
					}
				}
			}
		} 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	public ArrayList<String> getStartHourArray() {
		return startHourArray;
	}
	public ArrayList<String> getEndHourArray() {
		return endHourArray;
	}
	public ArrayList<String> getName() {
		return name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void printEvents() {
		for(int i = 0; i < startHourArray.size(); i++)
			System.out.println(startHourArray.get(i) + " - " +
							   endHourArray.get(i) + " " +
							   name.get(i) + "\n");
	}
}
