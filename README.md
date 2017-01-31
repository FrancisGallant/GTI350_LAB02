#GTI350_LAB02	– Conception	et	évaluation	des	interfaces	utilisateurs
Laboratoire	2:	Interface	multitactile	Android
Vous	avez	à	apporter	un	certain	nombre	de modifications	au	code	d’une	petite	application	à	
interface	 multitactile	 sous	 Android. Ces	 modifications	 auront	 pour	 effet	 d’ajouter	 de	
nouvelles	fonctionnalités	à	cette	interface.	
Débutez	avec	le	code	de	départ	du	laboratoire	2	(disponible	sur	le	site	du	cours)	que	vous	
allez	décompresser	et	placer	dans	votre	dossier	workspace d’Éclipse.	Pour	ceux	qui	veulent	
faire	le	travail	sur	leur	propre	machine,	il	y	a	en	annexe	à	cet	énoncé,	un	bref	tutoriel	pour	
l’installation	d’un	environnement	de	développement	Android.
Le code	de	départ	permet	déjà	d'effectuer	plusieurs	opérations:	
• 2	doigts	sur	le	fond:	zoom	et	translation	de	la	caméra	
• 2	doigts	sur	une	forme:	translation,	rotation,	et	changement	d'échelle	de	la	forme	
• 1	doigt	sur	le	bouton	"Lasso"	pour	se	mettre	en	mode	lasso:	1	autre	doigt	peut	
dessiner	une	courbe	lasso.	Les	formes	sélectionnées	par	le	lasso	sont	ensuite	
dessinées	avec	un	enveloppe	convexe	englobant.	
Vous	pouvez	consulter	la	présentation	PowerPoint	et	la vidéo	sur	le	site	du	cours	pour	plus	
de	détails	sur	le	fonctionnement	de	l’application	avec	le	code	de	départ.
Le	 nombre	 de	 modifications	 à	 apporter	 dans	 le	 code	 varie	 selon	 le	 nombre	 de	 membres	
dans	votre	équipe.	Ainsi,	une	équipe	de	N	personnes	doit	effectuer	des	modifications	valant	
N	points.
Voici	la	liste	des	modifications	que	vous	pouvez	effectuer	(voir	les	diapos	des	illustrations):	
• [1	point]	1	doigt	sur	la	sélection	actuelle:	translation	de	toutes	les	formes	
sélectionnées	
• [1	point]	Rajouter	un	bouton	"Effacer"	permettant	d'effacer	des	formes	complètes.	
Attention:	quand	vous	supprimez	une	forme,	assurez	vous	de	l'enlever	du	ArrayList	
selectedShapes,	sinon	ça	pourrait	rester	en	mémoire	
• [1	point]	Rajouter	un	bouton	"Encadrer"	qui	fait	un	zoom	pour	centrer	la	scène.	Pour	
programmer	cette	fonction,	faites	quelque	chose	comme	
gw.frame(shapeContainer.getBoundingRectangle(),true),	où	gw est	l'instance	de	
GraphicsWrapper
• [2	points]	Rajouter	un	bouton	"Créer"	permettant	de	créer	des	nouveaux	polygones.	
Conseil:	au	lieu	de	créer	le	nouveau	polygone	à	partir	des	positions	brutes	des	doigts	
(qui	peuvent	vous	arriver	dans	n'importe	quel	ordre),	utilisez	
Point2DUtil.computeConvexHull() pour	calculer	un	enveloppe	convexe	des	doigts,	et	
utilisez	cet	enveloppe	convexe	pour	créer	le	nouveau	polygone.
Quelques	endroits	intéressants	à	consulter	dans le	fichier	DrawingView.java:	
Page	2 de	8
• Le	constructeur	de	DrawingView qui	crée	les	trois	formes	de	départ	
• La	méthode	onDraw qui	dessine	tout	
• La	méthode	onTouch qui	traite	les	événements	de	toucher,	déplacement	de	doigts,	et	
relâchement	
Attention	de	bien	distinguer	entre	les	systèmes	de	coordonnées	monde	("world")	et	pixels.	
Remarquez	les	 appels	 dans	le	 code	 à	gw.setCoordinateSystemToWorldSpaceUnits() (pour	
dessiner	 en	 espace	 monde),	 gw.setCoordinateSystemToPixels() (pour	 dessiner	 en	 espace	
pixels),	 et	 gw.convertPixelsToWorldSpaceUnits (pour	 convertir	 d'un	 espace	 vers	 l'autre).	
Testez	 vos	 modifications	 à	 différents	 niveaux	 de	 zoom,	 pour	 confirmez	 que	 les	 formes	
suivent	toujours	vos	doigts	correctement.	
