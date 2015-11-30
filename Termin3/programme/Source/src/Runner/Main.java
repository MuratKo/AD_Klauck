package Runner;

import Helper.SortNum;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String path = "/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/";
		
		//zufällige 1000 Zahlen ohne Duplikate
		SortNum.sortNum(1000, path + "ohneDuplikate.dat", false);
		
		//zufällige 1000 Zahlen mit Duplikaten
		SortNum.sortNum(1000, path + "mitDuplikaten.dat", true);
		
		//worsecase
		SortNum.sortNumWorstBaseCase(1000, path + "worseCase.dat", false);
		
		//bestcase
		SortNum.sortNumWorstBaseCase(1000, path + "bestCase.dat", true);
	}

}
