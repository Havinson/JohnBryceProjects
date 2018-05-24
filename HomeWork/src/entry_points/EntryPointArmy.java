package entry_points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import il.co.johnbryce.homework.army.ComissionedOfficer;
import il.co.johnbryce.homework.army.ComissionedOfficer.Rank;
import il.co.johnbryce.homework.army.EnlistedSoldier;
import il.co.johnbryce.homework.army.SoldiersSorter;

public class EntryPointArmy {

	public static void main(String[] args) {
		List<EnlistedSoldier> soldiers = new ArrayList<>();
		EnlistedSoldier jim = new ComissionedOfficer(Rank.CAPTAIN, "Jim", "Rainor", 123665851);
		soldiers.add(jim);
		EnlistedSoldier sarra = new ComissionedOfficer(Rank.BRIGADIER_GENERAL, "Sarra", "Cerrigan", 516581498);
		soldiers.add(sarra);
		soldiers.add(new EnlistedSoldier(994561234, "Tychus", "Findlay"));
		soldiers.add(new EnlistedSoldier(516849531, "Gabriel", "Tosh"));
		soldiers.add(new ComissionedOfficer(Rank.LIEUTENANT_GENERAL, "Valerian", "Mengsk", 489315227));
		
		SoldiersSorter sorter = new SoldiersSorter();
		
		for(EnlistedSoldier curr: soldiers) {
			int minimumTime = (int)(Math.random() * 101);
			for(int i = 0; i < minimumTime; i++) {
				curr.anotherMonth();
			}
		}
		
		Collections.sort(soldiers, sorter);
		for(EnlistedSoldier curr: soldiers) {
			System.out.println(curr);
		}
		
		System.out.println("----------------------------------------");
		
		((ComissionedOfficer)jim).promote();
		((ComissionedOfficer)sarra).promote();

		for(EnlistedSoldier curr: soldiers) {
			System.out.println(curr);
		}
	}//main

}//EntryPoint
