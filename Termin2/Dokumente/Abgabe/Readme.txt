Inhalt des Programm-Ordners (jar-files):

1) quicksort.jar
2) insortionsort.jar



Einführung:

Mittels der oben genannten jar-Dateien, wurden die Sortieralgorithmen
Insortionsort und Quicksort implementiert. Um diese Nutzen zu können, folgen
Sie bitte der Installationsanleitung.



Installationsanleitung:

1) Legen Sie ein neues Java-Projekt an oder öffnen Sie ein 
   bestehendes.

2) Binden Sie eines oder mehrere der oben genannten jars ein. Wobei folgende Abhängigkeiten gelten:

	quicksort.jar -> adtarray.jar
	insortionsort.jar -> adtarray.jar

	adtlist.jar benötigt keine weitere jar
	adtstack.jar benötigt adtlist.jar
	adtqueue.jar benötigt adtstack.jar
	adtarray.jar benötigt adtlist.jar

3) Nun sind folgende Algorithmen verfügbar:
	Insortionsort.insortionsort(ADTarray a, int start, int end)
	Quicksort.quicksort(ADTArray a, Pivotelement pivotauswahl)
		Quicksort.Pivotauswahl: LINKS, RECHTS, RANDOM, MEDIANOF3

Viel Freude damit!
	

 