Inhalt des Programm-Ordners (jar-files):

1) avltree.jar
2) sortnum.jar



Einf�hrung:

Mittels der oben genannten jar-Datei (avltree.jar), wurde ein AVL-Baum implementiert.
Die sortnum.jar bietet die M�glichkeit Zufallszahlen beliebiger Anzahl(mit und ohne Duplikate) zu erzeugen.

Um diese Nutzen zu k�nnen, folgen Sie bitte der Installationsanleitung.



Installationsanleitung:

1) Legen Sie ein neues Java-Projekt an oder �ffnen Sie ein 
   bestehendes.

2) Binden Sie eines oder mehrere der oben genannten jars ein. 

3.1) Nun sind folgende methoden auf den AVL-baum verf�gbar:

		create: AVLTree.create() 
		isEmpty: <Objektname>.isEmpty()
		high: <Objektname>.high()
		insert: <Objektname>.insert(elem)
		delete: <Objektname>.delete(elem)
		print: <Objektname>.print(pfad, dateiName)
		
3.2) Folgende Methode ist durch die sortnum.jar verf�gbar.
		
		Sortnum.sortNum(anzahlZahlen, path, parameter) 
		
			RANDOM_WITH_DUBLICATES 		->	Zufallszahlen ohne Dublikate
			RANDOM_WITHOUT_DUBLICATES 	->	Zufallszahlen mit Dublikaten
			BEST_CASE 					->	Zahlen aufsteigend (1..Anzahl)
			WORST_CASE 					->	Zahlen absteigend (Anzahl..1)


Viel Freude damit!
	

 