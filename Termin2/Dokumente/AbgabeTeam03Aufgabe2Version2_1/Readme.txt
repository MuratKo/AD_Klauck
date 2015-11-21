Inhalt des Programm-Ordners (jar-files):

1) quicksort.jar
2) insortionsort.jar



Einf�hrung:

Mittels der oben genannten jar-Dateien, wurden die Sortieralgorithmen
Insortionsort und Quicksort implementiert. Um diese Nutzen zu k�nnen, folgen
Sie bitte der Installationsanleitung.



Installationsanleitung:

1) Legen Sie ein neues Java-Projekt an oder �ffnen Sie ein 
   bestehendes.

2) Binden Sie eines oder mehrere der oben genannten jars ein. Wobei folgende Abh�ngigkeiten gelten:

	quicksort.jar -> adtarray.jar
	insortionsort.jar -> adtarray.jar

	adtlist.jar ben�tigt keine weitere jar
	adtstack.jar ben�tigt adtlist.jar
	adtqueue.jar ben�tigt adtstack.jar
	adtarray.jar ben�tigt adtlist.jar

3) Nun sind folgende Algorithmen verf�gbar:
	Insortionsort.insortionsort(ADTarray a, int start, int end)
	Quicksort.quicksort(ADTArray a, Pivotelement pivotauswahl)
		Quicksort.Pivotauswahl: LINKS, RECHTS, RANDOM, MEDIANOF3

Viel Freude damit!
	

 