/*
 DHTML Menu version 3.3.19
 */

//The following line is critical for menu operation, and MUST APPEAR ONLY ONCE. If you have more than one menu_array.js file rem out this line in subsequent files
menunum=0;
menus=new Array();
_d=document;

function addmenu(){
	menunum++;
	menus[menunum]=menu;
	}

function dumpmenus(){
	mt="<script language=javascript>";
	for(a=1;a<menus.length;a++){
		mt+=" menu"+a+"=menus["+a+"];";
		}
	
	mt+="<\/script>";
	_d.write(mt)
}
//Please leave the above line intact. The above also needs to be enabled if it not already enabled unless this file is part of a multi pack.



////////////////////////////////////
// Editable properties START here //
////////////////////////////////////

// Special effect string for IE5.5 or above please visit http://www.milonic.co.uk/menu/filters_sample.php for more filters
if(navigator.appVersion.indexOf("MSIE 6.0")>0)
{
	effect = "Fade(duration=0.2);Alpha(style=0,opacity=88);Shadow(color='#777777', Direction=135, Strength=5)"
}
else
{
	effect = "Shadow(color='#777777', Direction=135, Strength=5)" // Stop IE5.5 bug when using more than one filter
}


timegap=500				// The time delay for menus to remain visible
followspeed=5		// Follow Scrolling speed
followrate=40			// Follow Scrolling Rate
suboffset_top=0;		// Sub menu offset Top position 
suboffset_left=0;		// Sub menu offset Left position

style1=[				// style1 is an array of properties. You can have as many property arrays as you need. This means that menus can have their own style.
"ffffff",					// Mouse Off Font Color
"333366",				// Mouse Off Background Color
"ffffff",				// Mouse On Font Color
"6593B5",				// Mouse On Background Color
"ffffff",				// Menu Border Color 
10,						// Font Size in pixels
"normal",				// Font Style (italic or normal)
"bold",					// Font Weight (bold or normal)
"Verdana, Arial",		// Font Name
3,						// Menu Item Padding
"html/img/triangle-orange.gif",			// Sub Menu Image (Leave this blank if not needed)
,						// 3D Border & Separator bar
"66ffff",				// 3D High Color
"000099",				// 3D Low Color
"ffffff",				// Current Page Item Font Color (leave this blank to disable)
"6593B5",					// Current Page Item Background Color (leave this blank to disable)
"",			// Top Bar image (Leave this blank to disable)
"ffffff",				// Menu Header Font Color (Leave blank if headers are not needed)
"",				// Menu Header Background Color (Leave blank if headers are not needed)
]

style2=[				// style1 is an array of properties. You can have as many property arrays as you need. This means that menus can have their own style.
"ffffff",					// Mouse Off Font Color
"6593B5",				// Mouse Off Background Color
"000060",				// Mouse On Font Color
"C3E3FA",				// Mouse On Background Color
"ffffff",				// Menu Border Color 
10,						// Font Size in pixels
"normal",				// Font Style (italic or normal)
"bold",					// Font Weight (bold or normal)
"Verdana, Arial",		// Font Name
3,						// Menu Item Padding
"html/claflib/triangle-orange.gif",			// Sub Menu Image (Leave this blank if not needed)
,						// 3D Border & Separator bar
"66ffff",				// 3D High Color
"000099",				// 3D Low Color
"ffffff",				// Current Page Item Font Color (leave this blank to disable)
"6593B5",					// Current Page Item Background Color (leave this blank to disable)
"",			// Top Bar image (Leave this blank to disable)
"ffffff",				// Menu Header Font Color (Leave blank if headers are not needed)
"",				// Menu Header Background Color (Leave blank if headers are not needed)
]


addmenu(menu=[		// This is the array that contains your menu properties and details
"mainmenu",			// Menu Name - This is needed in order for the menu to be called
69,					// Menu Top - The Top position of the menu in pixels
,				// Menu Left - The Left position of the menu in pixels
153,					// Menu Width - Menus width in pixels
1,					// Menu Border Width 
,			// Screen Position - here you can use "center;left;right;middle;top;bottom" or a combination of "center:middle"
style1,				// Properties Array - this is set higher up, as above
1,					// Always Visible - allows the menu item to be visible at all time (1=on/0=off)
"left",				// Alignment - sets the menu elements text alignment, values valid here are: left, right or center
,				// Filter - Text variable for setting transitional effects on menu activation - see above for more info
,					// Follow Scrolling - Tells the menu item to follow the user down the screen (visible at all times) (1=on/0=off)
1, 					// Horizontal Menu - Tells the menu to become horizontal instead of top to bottom style (1=on/0=off)
0,					// Keep Alive - Keeps the menu visible until the user moves over another menu or clicks elsewhere on the page (1=on/0=off)
,					// Position of TOP sub image left:center:right
,					// Set the Overall Width of Horizontal Menu to 100% and height to the specified amount (Leave blank to disable)
,					// Right To Left - Used in Hebrew for example. (1=on/0=off)
,					// Open the Menus OnClick - leave blank for OnMouseover (1=on/0=off)
,					// ID of the div you want to hide on MouseOver (useful for hiding form elements)
,					// Reserved for future use
,					// Reserved for future use
,					// Reserved for future use
,"Section 01","show-menu=list01","html/800x600_section01.html","",1 // "Description Text", "URL", "Alternate URL", "Status", "Separator Bar"
,"Section 02","show-menu=list02","html/800x600_section02.html","",1
,"Section 03","show-menu=list03","html/800x600_section03.html","",1
,"Section 04","show-menu=list04","html/800x600_section04.html","",1
])

	addmenu(menu=["list01",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"Chapter01","show-menu=list05",,"Chapter01",1
	,"Chapter02","show-menu=list06",,"Chapter01",1
	,"Chapter03","show-menu=list07",,"Chapter01",1
	])
	
	addmenu(menu=["list02",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"Chapter01","html/800x600_chapter01.html",,,1
	])
	
	addmenu(menu=["list03",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
    ,"Chapter01","show-menu=list08",,"Chapter01",1
	,"Chapter02","show-menu=list09",,"Chapter01",1
	])
	
	addmenu(menu=["list04",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"Chapter01","html/800x600_chapter01.html",,,1
	,"Chapter02","html/800x600_chapter02.html",,,1
	])
	
	addmenu(menu=["list05",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"SubChapter01","html/800x600_chapter01.html",,,1
	,"SubChapter02","html/800x600_chapter01.html",,,1
	,"SubChapter03","html/800x600_chapter01.html",,,1

	])
	
	addmenu(menu=["list06",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"SubChapter01","html/800x600_chapter01.html",,,1
	,"SubChapter02","html/800x600_chapter01.html",,,1
	,"SubChapter03","html/800x600_chapter01.html",,,1

	])
	
	addmenu(menu=["list07",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"SubChapter01","html/800x600_chapter01.html",,,1
	,"SubChapter02","html/800x600_chapter01.html",,,1
	,"SubChapter03","html/800x600_chapter01.html",,,1

	])
	
	addmenu(menu=["list08",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"SubChapter01","html/800x600_chapter01.html",,,1
	,"SubChapter02","html/800x600_chapter01.html",,,1
	,"SubChapter03","html/800x600_chapter01.html",,,1

	])
	
	addmenu(menu=["list09",
	,,155,1,"",style2,,"left",,,,,,,,,,,,,
	,"SubChapter01","html/800x600_chapter01.html",,,1
	,"SubChapter02","html/800x600_chapter01.html",,,1
	,"SubChapter03","html/800x600_chapter01.html",,,1

	])

dumpmenus()