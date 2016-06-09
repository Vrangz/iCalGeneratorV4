package iCalGenerator;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class ParseUzSite {
	static ArrayList<String> startHourArray = new ArrayList<>();
	static ArrayList<String> endHourArray = new ArrayList<>();
	static ArrayList<String> name = new ArrayList<>();
	public static void main(String args[]) throws IOException {
		try {
			Document uzPlan = Jsoup.connect("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16670").get();
			Document uzTerm = Jsoup.connect("http://plan.uz.zgora.pl/kalendarze_lista_szczegoly.php?pId_kalendarz=1612").get();
			Elements days = uzPlan.select("p");
			
			String startHour;
			String endHour;
			Element temp;
			String date;
			Element dates;
			for(int i = 0; i < days.size(); i++) {
		//		System.out.println(days.get(i).text());
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
					if( date.equals("D/") ) {
						dates = uzTerm.select("table").get(1).child(0).child(1);
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
							catch(Exception e) {break;}
						}
					}
					else if( date.equals("DI/") ) {
						dates = uzTerm.select("table").get(2).child(0).child(1);
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
							catch(Exception e) {break;}
						}
					}
					if( date.equals("DII/") ) {
						dates = uzTerm.select("table").get(3).child(0).child(1);
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
							catch(Exception e) {break;}
						}
					}
					if( date.equals("DN/") ) {
						dates = uzTerm.select("table").get(4).child(0).child(1);
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
							catch(Exception e) {break;}
						}
					}
					if( date.equals("DP/") ) {
						dates = uzTerm.select("table").get(4).child(0).child(1);
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
							catch(Exception e) {break;}
						}
					}
					else {
						startHourArray.add(date + " " + startHour);
						endHourArray.add(date + " " + endHour);
						name.add(temp.child(3).text());
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
}
