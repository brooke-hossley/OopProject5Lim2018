import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.io.*;
/**
 * Class to create the routes of the game
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class Route
{
    //How many trains needed to claim the route
    protected int length; 
    //Arrays to hold the city information
    protected ArrayList<String> cityNames;
    protected ArrayList<City> twoCities;
    //The possible colors of the routes
    protected ArrayList<RouteColor> color; 
    //Polygon of the route to use as bounds for mouseHover/Click
    protected Polygon routeShape;
    //Player's color once the route is claimed
    protected Color occupiedByColor;
    //Array that holds locations of trains occypying the route once claimed 
    protected Polygon[] occupyingTrains;

    /**
     * Constructor with parameters of the Route class
     * 
     * @param cityOneName The first city of that route
     * @param cityTwoName The second city of that route
     * @param map A hashmap of the cities 
     */
    public Route(String cityOneName, String cityTwoName, 
    HashMap<String, City> map)
    {
        //Creating the ArrayLists
        twoCities = new ArrayList(2);
        color = new ArrayList<RouteColor>();
        cityNames = new ArrayList<String>(2);
        //Adding to the ArrayLists
        cityNames.add(cityOneName);
        cityNames.add(cityTwoName);
        twoCities.add(map.get(cityOneName));
        twoCities.add(map.get(cityTwoName));
        //Constructing the routes 
        if (cityNames.contains("Danemark"))//Starting Cities
        {
            if(cityNames.contains("Kiel"))//Branching cities
            {
                //Assigning the length of the route
                length = 2;
                //Assigning the color of the route
                color.add(RouteColor.GRAY);
                //Constructing the polygons for the routes
                int [] a129 = {698,710,686,693,716,720,708};
                int [] a130 = {93 ,65 ,47 ,40 ,56 ,70 ,97};
                routeShape = new Polygon(a129,a130,7);
            }//Rinse and repeat 
            else if(cityNames.contains("Bremerhaven"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                int [] a131 = {606,602,605,614,628,648,640,619,604,595,593,596};
                int [] a132 = {179,150,119,89 ,62 ,41 ,35 ,57 ,86 ,118,150,180};
                routeShape = new Polygon(a131,a132,12);
            }
        }
        if (cityNames.contains("Kiel"))
        {
            if(cityNames.contains("Rostock"))
            {
                length = 5;
                color.add(RouteColor.ORANGE);
                int [] a127 = {831,802,772,741,713,709,739,772,805,834};
                int [] a128 = {110,101,97 ,100,108,100,90 ,87 ,91 ,101};
                routeShape = new Polygon(a127,a128,10);
            }
            else if (cityNames.contains("Schwerin"))
            {
                length = 5;
                color.add(RouteColor.YELLOW);
                int [] a125 = {782,762,737,710,716,743,769,791};
                int [] a126 = {172,151,133,121,110,124,142,165};
                routeShape = new Polygon(a125,a126,8);
            }
            else if (cityNames.contains("Hamburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.PINK);
                int [] a107 = {708,686,697,718};
                int [] a108 = {121,124,183,179};
                routeShape = new Polygon(a107,a108,4);
            }
            else if (cityNames.contains("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a111 = {684,677,610,616};
                int [] a112 = {123,115,177,183};
                routeShape = new Polygon(a111,a112,4);
            }
        }
        if (cityNames.contains("Rostock"))
        {
            if (cityNames.contains("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.RED);
                int [] a33 = {841, 834, 798, 805};
                int [] a34 = {126, 121, 169, 175};
                routeShape = new Polygon(a33,a34,4);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 6;
                color.add(RouteColor.PINK);
                int [] a121 = {930,929,922,911,896,876,852,
                        859,883,905,920,932,940,940};
                int [] a122 = {281,252,223,194,167,144,126,
                        118,136,161,189,219,251,282};
                routeShape = new Polygon(a121,a122,14);
            }
        }
        if (cityNames.contains("Schwerin"))
        {
            if (cityNames.contains("Hamburg"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
                int [] a123 = {777,750,727,720,749,781};
                int [] a124 = {184,171,188,181,160,175};
                routeShape = new Polygon(a123,a124,6);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 5;
                color.add(RouteColor.WHITE);
                int [] a119 = {919,904,883,860,835,807,811,839,866,890,911,928};
                int [] a120 = {286,261,237,218,201,191,181,190,208,229,254,282};
                routeShape = new Polygon(a119,a120,12);
            }
        }
        if (cityNames.contains("Hamburg"))
        {
            if(cityNames.contains("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
                //Hamburg to Berlin
                int [] a1 = {732, 720, 909, 921};
                int [] a2 = {189, 208, 308, 289};
                routeShape = new Polygon(a1,a2,4);
            }
            else if (cityNames.contains("Hannover"))
            {
                length = 4;
                color.add(RouteColor.RED);
                color.add(RouteColor.WHITE);
                //Hamburg to Hannover
                int [] a3 = {719, 697, 667, 690};
                int [] a4 = {207, 201, 321, 325};
                routeShape = new Polygon(a3,a4,4);
            }
            else if (cityNames.contains("Bremen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
                int [] a137 = {621,680,688,695,685,678,618};
                int [] a138 = {253,237,229,202,199,227,243};
                routeShape = new Polygon(a137,a138,7);
            }
            else if (cityNames.contains("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a135 = {626,648,664,696,698,669,649,619};
                int [] a136 = {193,173,189,197,186,180,159,186};
                routeShape = new Polygon(a135,a136,8);
            }
        }
        if (cityNames.contains("Bremerhaven"))
        {
            if (cityNames.contains("Bremen"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
                int [] a109 = {609,599,602,612};
                int [] a110 = {206,206,236,235};
                routeShape = new Polygon(a109,a110,4);
            }
            else if (cityNames.contains("Emden"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a133 = {588,561,531,510,502,526,559,567,593};
                int [] a134 = {190,176,181,203,197,172,166,167,180};
                routeShape = new Polygon(a133,a134,9);
            }
        }
        if (cityNames.contains("Emden"))
        {
            if (cityNames.contains("Bremen"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
                int [] a103 = {595,599,513,509};
                int [] a104 = {247,237,209,218};
                routeShape = new Polygon(a103,a104,4);
            }
            else if (cityNames.contains("Munster"))
            {
                length = 4;
                color.add(RouteColor.RED);
                int [] a99 = {507,497,528,537};
                int [] a100 = {223,225,341,340};
                routeShape = new Polygon(a99,a100,4);
            }
            else if (cityNames.contains("Niederlande"))
            {
                length = 2;
                color.add(RouteColor.WHITE);
                int [] a105 = {491,484,445,452};
                int [] a106 = {223,215,262,269};
                routeShape = new Polygon(a105,a106,4);
            }
        }
        if (cityNames.contains("Bremen"))
        {
            if (cityNames.contains("Munster"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
                int [] a101 = {601,592,541,549};
                int [] a102 = {265,262,336,342};
                routeShape = new Polygon(a101,a102,4);
            }
            else if (cityNames.contains("Hannover"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
                int [] a139 = {606,625,636,665,665,636,617};
                int [] a140 = {261,319,325,326,316,314,257};
                routeShape = new Polygon(a139,a140,7);
            }
        }
        if (cityNames.contains("Niederlande"))
        {
            if (cityNames.contains("Munster"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
                int [] a97 = {517,522,466,462};
                int [] a98 = {356,346,326,334};
                routeShape = new Polygon(a97,a98,4);
            }
            else if (cityNames.contains("Dusseldorf"))
            {
                length = 3;
                color.add(RouteColor.PINK);
                int [] a93 = {440,430,461,470};
                int [] a94 = {336,340,425,421};
                routeShape = new Polygon(a93,a94,4);
            }
        }
        if (cityNames.contains("Munster"))
        {
            if (cityNames.contains("Hannover"))
            {
                length = 4;
                color.add(RouteColor.PINK);
                int [] a141 = {544,575,606,635,664,663,632,602,575,546};
                int [] a142 = {365,371,355,344,338,329,334,346,361,355};
                routeShape = new Polygon(a141,a142,10);
            }
            else if (cityNames.contains("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a95 = {541,520,512,534};
                int [] a96 = {374,369,399,402};
                routeShape = new Polygon(a95,a96,4);
            }
        }
        if (cityNames.contains("Hannover"))
        {
            if (cityNames.contains("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a147 = {671,667,667,671,649,645,645,649};
                int [] a148 = {346,376,407,436,437,407,375,345};
                routeShape= new Polygon(a147,a148,8);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                color.add(RouteColor.ORANGE);
                int [] a7 = {692, 672, 751, 771};
                int [] a8 = {338, 349, 481, 469};
                routeShape= new Polygon(a7,a8,4);
            }
            else if (cityNames.contains("Magdeburg"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                int [] a143 = {816,786,751,719,696,702,724,753,784,813};
                int [] a144 = {365,374,373,360,340,333,352,363,363,356};
                routeShape= new Polygon(a143,a144,10);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLACK);
                //Hannover to Berlin
                int [] a5 = {694, 694, 909, 909};
                int [] a6 = {320, 329, 321, 310};
                routeShape = new Polygon(a5,a6,4);
            }
        }
        if (cityNames.contains("Berlin"))
        {
            if (cityNames.contains("Magdeburg"))
            {
                length = 3;
                color.add(RouteColor.RED);
                int [] a117 = {917,897,837,838,899,906,925};
                int [] a118 = {318,339,350,360,350,346,324};
                routeShape = new Polygon(a117,a118,7);
            }
            else if (cityNames.contains("Leipzig"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
                int [] a115 = {928,924,865,873,935,938};
                int [] a116 = {321,350,421,428,355,322};
                routeShape = new Polygon(a115,a116,6);
            }
            else if (cityNames.contains("Dresden"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                int [] a113 = {937,953,964,968,969,966,976,980,979,974,963,947};
                int [] a114 = {317,341,370,400,431,460,461,432,400,367,337,310};
                routeShape = new Polygon(a113,a114,12);
            }
        }
        if (cityNames.contains("Magdeburg"))
        {
            if (cityNames.contains("Leipzig"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
                int [] a31 = {836, 825, 849, 859};
                int [] a32 = {366, 370, 425, 421};
                routeShape = new Polygon(a31,a32,4);
            }
        }
        if (cityNames.contains("Dusseldorf"))
        {
            if (cityNames.contains("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a91 = {518,505,476,490};
                int [] a92 = {434,402,415,446};
                routeShape = new Polygon(a91,a92,4);
            }
            else if (cityNames.contains("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a89 = {485,451,450,484};
                int [] a90 = {451,451,481,481};
                routeShape = new Polygon(a89,a90,4);
            }
        }
        if (cityNames.contains("Kassel"))
        {
            if (cityNames.contains("Dortmund"))
            {
                length = 4;
                color.add(RouteColor.GREEN);
                int [] a149 = {648,618,584,551,527,534,556,585,616,645};
                int [] a150 = {451,460,461,449,429,421,440,450,451,442};
                routeShape = new Polygon(a149,a150,10);
            }
        }
        if (cityNames.contains("Leipzig"))
        {
            if (cityNames.contains("Dresden"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
                int [] a27 = {875, 872, 957, 961};
                int [] a28 = {432, 441, 471, 461};
                routeShape = new Polygon(a27,a28,4);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
                int [] a29 = {870, 862, 904, 911};
                int [] a30 = {442, 449, 491, 484};
                routeShape = new Polygon(a29,a30,4);
            }
        }
        if (cityNames.contains("Chemnitz"))
        {
            if(cityNames.contains("Dresden"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
                int [] a35 = {954, 958, 930, 926};
                int [] a36 = {474, 482, 497, 486};
                routeShape = new Polygon(a35,a36,4);
            }
        }
        if (cityNames.contains("Erfurt"))
        {
            if (cityNames.contains("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a151 = {755,723,687,671,680,695,724,753};
                int [] a152 = {494,502,489,462,456,481,493,484};
                routeShape = new Polygon(a151,a152,8);
            }
            else if (cityNames.contains("Nurnberg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
                color.add(RouteColor.PINK);
                int [] a11 = {778, 755, 758, 780};
                int [] a12 = {498, 498, 620, 619};
                routeShape = new Polygon(a11,a12,4);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
                int [] a9 = {782, 781, 903, 903};
                int [] a10 = {481, 490, 502, 492};
                routeShape = new Polygon(a9,a10,4);
            }
            else if (cityNames.contains("Leipzig"))
            {
                length = 3;
                color.add(RouteColor.RED);
                int [] a145 = {849,819,793,781,772,785,816,849};
                int [] a146 = {438,435,451,479,476,445,425,429};
                routeShape = new Polygon(a145,a146,8);
            }
        }
        if (cityNames.contains("Koln"))
        {
            if(cityNames.contains("Dusseldorf"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a89 = {485,451,450,484};
                int [] a90 = {451,451,481,481};
                routeShape = new Polygon(a89,a90,4);
            }
        }
        if (cityNames.contains("Frankfurt"))
        {
            if(cityNames.contains("Kassel"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
                int [] a153 = {669,670,662,638,612,606,600,
                        596,621,640,647,646,657,658};
                int [] a154 = {463,494,528,555,573,563,564,
                        556,538,516,485,455,456,463};
                routeShape = new Polygon(a153,a154,14);
            }
            else if (cityNames.contains("Wurzburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a79 = {621,612,668,676};
                int [] a80 = {569,590,613,591};
                routeShape = new Polygon(a79,a80,4);
            }
            else if (cityNames.contains("Koln"))
            {
                length = 4;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a87 = {490,477,582,594};
                int [] a88 = {488,508,570,550};
                routeShape = new Polygon(a87,a88,4);
            }
        }
        if (cityNames.contains("Koblenz"))
        {
            if(cityNames.contains("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a85 = {477,455,463,485};
                int [] a86 = {512,519,546,540};
                routeShape = new Polygon(a85,a86,4);
            }
            else if (cityNames.contains("Mainz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a73 = {498,485,533,547};
                int [] a74= {555,574,608,590};
                routeShape = new Polygon(a73,a74,4);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a71 = {478,469,451,461};
                int [] a72 = {569,567,656,657};
                routeShape = new Polygon(a71,a72,4);
            }
        }
        if (cityNames.contains("Mainz"))
        {
            if (cityNames.contains("Frankfurt"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a75 = {593,580,555,567};
                int [] a76 = {589,571,589,607};
                routeShape = new Polygon(a75,a76,4);
            }
            else if (cityNames.contains("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a65 = {569, 547, 559, 579 };
                int [] a66 = {614, 624, 649, 641};
                routeShape = new Polygon(a65,a66,4);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a83 = {545,540,464,469};
                int [] a84 = {619,610,661,668};
                routeShape = new Polygon(a83,a84,4);
            }
        }
        if (cityNames.contains("Wurzburg"))
        {
            if (cityNames.contains("Nurnberg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a81 = {700,692,748,757};
                int [] a82 = {600,621,643,622};
                routeShape = new Polygon(a81,a82,4);
            }
        }
        if (cityNames.contains("Nurnberg"))
        {
            if (cityNames.contains("Augsburg"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
                int [] a17 = {763, 753, 747, 758};
                int [] a18 = {641, 641, 763, 763};
                routeShape= new Polygon(a17,a18,4);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.BLUE);
                int [] a15 = {788, 766, 827, 848};
                int [] a16 = {637, 647, 786, 778};
                routeShape= new Polygon(a15,a16,4);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
                int [] a13 = {792, 785, 860, 866};
                int [] a14 = {624, 632, 684, 677};
                routeShape= new Polygon(a13,a14,4);
            }
        }
        if (cityNames.contains("Regensburg"))
        {
            if(cityNames.contains("Dresden"))
            {
                length = 7;
                color.add(RouteColor.RED);
                int [] a167 = {893,909,922,932,961,970,942,931,918,901};
                int [] a168 = {687,662,633,604,485,487,606,637,666,692};
                routeShape= new Polygon(a167,a168,10);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 6;
                color.add(RouteColor.PINK);
                int [] a165 = {880,879,883,906,912,891,890};
                int [] a166 = {683,531,522,504,511,531,684};
                routeShape= new Polygon(a165,a166,7);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 7;
                color.add(RouteColor.WHITE);
                int [] a163 = {868,868,860,847,829,807,781,
                        787,813,837,855,870,878,878};
                int [] a164 = {684,623,594,567,540,520,505,
                        496,512,534,561,590,622,684};
                routeShape= new Polygon(a163,a164,14);
            }
            else if (cityNames.contains("Osterreich"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
                int [] a25 = {901, 891, 958, 968};
                int [] a26 = {699, 706, 807, 801};
                routeShape= new Polygon(a25,a26,4);
            }
        }
        if (cityNames.contains("Mannheim"))
        {
            if (cityNames.contains("Frankfurt"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a77 = {617,596,582,603};
                int [] a78 = {595,590,648,652};
                routeShape = new Polygon(a77,a78,4);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a63 = {599, 580, 616, 634};
                int [] a64 = {658, 672, 721, 707};
                routeShape = new Polygon(a63,a64,4);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a67 = {563, 563, 473, 472};
                int [] a68 = {657, 666, 678, 669};
                routeShape = new Polygon(a67,a68,4);
            }
        }
        if (cityNames.contains("Saarbrucken"))
        {
            if(cityNames.contains("Frankreich"))
            {
                length = 1;
                color.add(RouteColor.GREEN);
                int [] a69 = {458,449,444,453};
                int [] a70 = {685,684,712,714};
                routeShape = new Polygon(a69,a70,4);
            }
        }
        if (cityNames.contains("Karlsruhe"))
        {
            if(cityNames.contains("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.BLUE);
                int [] a59 = {576, 566, 566, 576};
                int [] a60= {672, 672, 700, 700};
                routeShape = new Polygon(a59,a60,4);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a155 = {464,488,522,553,553,523,492,472};
                int [] a156 = {687,709,716,714,704,706,700,680};
                routeShape = new Polygon(a155,a156,8);
            }
            else if (cityNames.contains("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
                int [] a61 = {560, 555, 502, 507};
                int [] a62 = {725, 717, 745, 754};
                routeShape = new Polygon(a61,a62,4);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 1;
                color.add(RouteColor.PINK);
                int [] a57 = {587, 584, 611, 614};
                int [] a58 = {714, 724, 731, 722};
                routeShape = new Polygon(a57,a58,4);
            }
        }
        if (cityNames.contains("Ulm"))
        {
            if(cityNames.contains("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a39 = {649, 635, 684, 699};
                int [] a40 = {721, 739, 774, 755};
                routeShape = new Polygon(a39,a40,4);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 2;
                color.add(RouteColor.RED);
                int [] a37 = {699, 691, 674, 684};
                int [] a38 = {787, 785, 842, 845};
                routeShape = new Polygon(a37,a38,4);
            }
        }
        if (cityNames.contains("Augsburg"))
        {
            if (cityNames.contains("Munchen"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a19 = {768, 762, 820, 825};
                int [] a20 = {771, 793, 807, 787};
                routeShape = new Polygon(a19,a20,4);
            }
            else if (cityNames.contains("Ulm"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a21 = {743, 741, 713, 713};
                int [] a22 = {763, 785, 783, 762};
                routeShape = new Polygon(a21,a22,4);
            }
        }
        if (cityNames.contains("Munchen"))
        {
            if (cityNames.contains("Osterreich"))
            {
                length = 3;
                color.add(RouteColor.RED);
                int [] a23 = {853, 845, 910, 919};
                int [] a24 = {802, 811, 873, 866};
                routeShape = new Polygon(a23,a24,4);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
                int [] a161 = {851,879,884,896,898,891,880,886,874,848};
                int [] a162 = {792,779,773,746,738,711,712,741,769,784};
                routeShape = new Polygon(a161,a162,10);
            }
        }
        if (cityNames.contains("Freiburg"))
        {
            if(cityNames.contains("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
                int [] a55 = {525, 527, 469, 467};
                int [] a56 = {824, 814, 800, 811};
                routeShape = new Polygon(a55,a56,4);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 3;
                color.add(RouteColor.WHITE);
                int [] a53 = {575, 566, 538, 547};
                int [] a54 = {726, 724, 811, 813};
                routeShape = new Polygon(a53,a54,4);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a51 = {620, 612, 553, 559};
                int [] a52 = {744, 737, 808, 815};
                routeShape = new Polygon(a51,a52,4);
            }
        }
        if (cityNames.contains("Konstanz"))
        {
            if(cityNames.contains("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
                int [] a47 = {611, 613, 554, 552};
                int [] a48 = {845, 835, 820, 831};
                routeShape = new Polygon(a47,a48,4);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
                int [] a45 = {633, 623, 620, 631};
                int [] a46 = {741, 741, 832, 832};
                routeShape = new Polygon(a45,a46,4);
            }
            else if (cityNames.contains("Schweiz"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
                int [] a49 = {612, 619, 595, 589};
                int [] a50 = {848, 856, 874, 866};
                routeShape = new Polygon(a49,a50,4);
            }
        }
        if (cityNames.contains("Lindau"))
        {
            if(cityNames.contains("Konstanz"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
                int [] a43 = {640, 637, 665, 667};
                int [] a44 = {841, 850, 857, 848};
                routeShape = new Polygon(a43,a44,4);
            }
            else if (cityNames.contains("Schweiz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
                int [] a41 = {693, 689, 744, 748};
                int [] a42 = {857, 865, 886, 875};
                routeShape = new Polygon(a41,a42,4);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 5;
                color.add(RouteColor.GRAY);
                int [] a169 = {692,722,754,784,815,841,835,810,782,752,722,692};
                int [] a170 = {854,856,853,846,833,817,809,824,836,844,847,844};
                routeShape = new Polygon(a169,a170,12);
            }
            else if (cityNames.contains("Osterreich")) 
            {
                int [] a41 = {693, 689, 744, 748};
                int [] a42 = {857, 865, 886, 875};
                routeShape = new Polygon(a41,a42,4);

            }
        }
        if (cityNames.contains("Schweiz"))
        {
            if(cityNames.contains("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
                int [] a157 = {525,503,530,539,517,533};
                int [] a158 = {833,867,894,886,865,838};
                routeShape = new Polygon(a157,a158,6);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
                int [] a159 = {667,646,617,617,647,654,674};
                int [] a160 = {863,884,886,896,895,891,869};
                routeShape = new Polygon(a159,a160,7);
            }
        }

        //Question
        //shift all the x coordinates to account for 
        //background picture being off when gathering coordinates
        if (routeShape != null) 
        {
            for (int i = 0; i < routeShape.xpoints.length; i++) 
            {
                routeShape.xpoints[i] -=127;
            }
        }
    }

    /**
     * Mathod to see if the mouse is within a route
     * 
     * @param x X-coordinate of the mouse
     * @param y Y-coordinate of the mouse
     * @return boolean If the mouse is within the x and y coordinates
     */
    protected boolean containsMouse(int x, int y)
    {
        if (routeShape == null) return false;
        return routeShape.contains(x, y);
    }
    
    /**
     * Method to create a string of the route
     * 
     * @return String Route name
     */
    public String toString() 
    {
        return twoCities.get(0).name + " to " + twoCities.get(1).name;
    }

    /**
     * Method that returns and arraylist of colors for user 
     * to choose from when choosing Route
     * 
     * @return String[] An array of colors 
     */
    protected String[] getCardColors()
    {
        //Construt array
        String[] cardColors;
        if (color.contains(RouteColor.GRAY)) 
        /*Checking the color of the route and 
        what cards allowed to be use to claim the route*/
        {
            cardColors = new String[8];
            cardColors[0] = "Yellow";
            cardColors[1] = "Blue";
            cardColors[2] = "Green";
            cardColors[3] = "Pink";
            cardColors[4] = "Red";
            cardColors[5] = "Black";
            cardColors[6] = "Orange";
            cardColors[7] = "White";
            return cardColors;
        }
        //Question 
        cardColors = new String[color.size()];
        int index = 0;
        if (color.contains(RouteColor.YELLOW)) {
            cardColors[index] = "Yellow"; 
            index = 1;
        }
        if (color.contains(RouteColor.BLUE)) {
            cardColors[index] = "Blue"; 
            index = 1;
        }
        if (color.contains(RouteColor.GREEN)) {
            cardColors[index] = "Green"; 
            index = 1;
        }
        if (color.contains(RouteColor.PINK)) {
            cardColors[index] = "Pink"; 
            index = 1;
        }
        if (color.contains(RouteColor.RED)) {
            cardColors[index] = "Red"; 
            index = 1;
        }
        if (color.contains(RouteColor.BLACK)) {
            cardColors[index] = "Black"; 
            index = 1;
        }
        if (color.contains(RouteColor.ORANGE)) {
            cardColors[index] = "Orange"; 
            index = 1;
        }
        if (color.contains(RouteColor.WHITE)) {
            cardColors[index] = "White"; 
            index = 1;
        }

        return cardColors;
    }

    /**
     * Method to check if the route is open to take
     * 
     * @return boolean If the route is open or not
     */
    protected boolean isOpen()
    {
        return occupiedByColor == null;
    }
}
