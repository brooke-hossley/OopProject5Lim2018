import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

////////////////////////////////////////////////////////////////////////////////
/**
 * Idk what I'm doing I'm still figuring this class out
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route extends JPanel
{
    //How many trains needed to claim the route
    protected int length; 

    //hold the two cities
    protected ArrayList<String> cityNames;
    protected ArrayList<City> twoCities;

    //The possible colors of the route
    protected ArrayList<RouteColor> color; 

    //polygon to use as bounds for mouse hover and click
    protected Polygon routeShape;

    //player's color once occupying the route
    protected Color occupiedByColor;

    //holds locations of trains occypying route once it's claimed by a player
    protected Polygon[] occupyingTrains;

    private static Image board, blackBackground;

    public Route(String cityOneName, String cityTwoName, HashMap<String, City> map)
    {
        twoCities = new ArrayList(2);
        color = new ArrayList<RouteColor>();
        cityNames = new ArrayList<String>(2);

        cityNames.add(cityOneName);
        cityNames.add(cityTwoName);
        twoCities.add(map.get(cityOneName));
        twoCities.add(map.get(cityTwoName));

        if (cityNames.contains("Danemark"))
        {
            if(cityNames.contains("Kiel"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                int [] a129 = {698,710,686,693,716,720,708};
                int [] a130 = {93 ,65 ,47 ,40 ,56 ,70 ,97};
                routeShape = new Polygon(a129,a130,7);
            }
            else if(cityNames.contains("Bremerhaven"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                int [] a131 = {606,602,605,614,628,648,640,619,604,595,593,596};
                int [] a132 = {179,150,119,89 ,62 ,41 ,35 ,57 ,86 ,118,150,180};
                routeShape = new Polygon(a131,a132,12);
            }
        }
        else if (cityNames.contains("Kiel"))
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
        else if (cityNames.contains("Rostock"))
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
                int [] a121 = {930,929,922,911,896,876,852,859,883,905,920,932,940,940};
                int [] a122 = {281,252,223,194,167,144,126,118,136,161,189,219,251,282};
                routeShape = new Polygon(a121,a122,14);
            }
        }
        else if (cityNames.contains("Schwerin"))
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
        else if (cityNames.contains("Hamburg"))
        {
            if(cityNames.contains("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
                //Hamburg to Berlin
                int [] a1 = {605, 593, 782, 794};
                int [] a2 = {189, 208, 308, 289};
                routeShape = new Polygon(a1,a2,4);
            }
            else if (cityNames.contains("Hannover"))
            {
                length = 4;
                color.add(RouteColor.RED);
                color.add(RouteColor.WHITE);
                //Hamburg to Hannover
                int [] a3 = {592, 570, 540, 563};
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
        else if (cityNames.contains("Bremerhaven"))
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
        else if (cityNames.contains("Emden"))
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
        else if (cityNames.contains("Bremen"))
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
        else if (cityNames.contains("Niederlande"))
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
        else if (cityNames.contains("Munster"))
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
        else if (cityNames.contains("Hannover"))
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
                int [] a7 = {565, 545, 624, 644};
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
                int [] a5 = {567, 567, 782, 782};
                int [] a6 = {320, 329, 321, 310};
                routeShape = new Polygon(a5,a6,4);
            }
        }
        else if (cityNames.contains("Berlin"))
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
        else if (cityNames.contains("Magdeburg"))
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
        else if (cityNames.contains("Dusseldorf"))
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
        else if (cityNames.contains("Kassel"))
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
        else if (cityNames.contains("Leipzig"))
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
        else if (cityNames.contains("Chemnitz"))
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
        else if (cityNames.contains("Erfurt"))
        {
            if (cityNames.contains("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                int [] a151 = {755,723,687,671,680,695,724,753};
                int [] a152 = {494,502,489,462,456,481,493,484};
                routeShape = new Polygon(a151,a152,8);
            }
            else if (cityNames.contains("Nurnburg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
                color.add(RouteColor.PINK);
                int [] a11 = {651, 628, 631, 653};
                int [] a12 = {498, 498, 620, 619};
                routeShape = new Polygon(a11,a12,4);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
                int [] a9 = {655, 654, 776, 776};
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
        else if (cityNames.contains("Koln"))
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
        else if (cityNames.contains("Frankfurt"))
        {
            if(cityNames.contains("Kassel"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
                int [] a153 = {669,670,662,638,612,606,600,596,621,640,647,646,657,658};
                int [] a154 = {463,494,528,555,573,563,564,556,538,516,485,455,456,463};
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
        else if (cityNames.contains("Koblenz"))
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
        else if (cityNames.contains("Mainz"))
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
        else if (cityNames.contains("Wurzburg"))
        {
            if (cityNames.contains("Nurnburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                int [] a81 = {700,692,748,757};
                int [] a82 = {600,621,643,622};
                routeShape = new Polygon(a81,a82,4);
            }
        }
        else if (cityNames.contains("Nurnburg"))
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
                int [] a13 = {665, 658, 733, 739};
                int [] a14 = {624, 632, 684, 677};
                routeShape= new Polygon(a13,a14,4);
            }
        }
        else if (cityNames.contains("Regensburg"))
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
                int [] a163 = {868,868,860,847,829,807,781,787,813,837,855,870,878,878};
                int [] a164 = {684,623,594,567,540,520,505,496,512,534,561,590,622,684};
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
        else if (cityNames.contains("Mannheim"))
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
        else if (cityNames.contains("Saarbrucken"))
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
        else if (cityNames.contains("Karlsruhe"))
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
        else if (cityNames.contains("Ulm"))
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
        else if (cityNames.contains("Augsburg"))
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
        else if (cityNames.contains("Munchen"))
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
        else if (cityNames.contains("Freiburg"))
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
        else if (cityNames.contains("Konstanz"))
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
        else if (cityNames.contains("Lindau"))
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
        }
        else if (cityNames.contains("Schweiz"))
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

        //map.get(cityOneName).addRoute(this);
        //map.get(cityTwoName).addRoute(this);

    }

    protected void addToCities() {
        for (City c: twoCities) {
            c.addRoute(this);
        }
    }

    protected boolean containsMouse(int x, int y){
        if (routeShape == null) return false;
        return routeShape.contains(x, y);
    }

    //check is route is open to take
    protected boolean isOpen(){
        return occupiedByColor == null;
    }

    public String toString() {
        return twoCities.get(0).name + twoCities.get(1).name;
    }

    public static String getStringrouteColor(RouteColor col) {
        if(col == RouteColor.YELLOW)
        {
            return "yellow";
        }
        else if(col == RouteColor.ORANGE)
        {
            return "orange";
        }
        // return "orange";
        // return "green";
        // return "blue";
        // return "red";
        // return "gray";
        // return "white";
        // return "black";
        // return "purple";
        //else
        else {
            return "nosuchcolor";
        }
    }

    protected int getRouteLength(){
        return length;   
    }

    public Route()
    {
        String dir = "Images//";
        board = new ImageIcon(dir + "Board.JPG").getImage();
        blackBackground = new ImageIcon(dir + "blackBackground.JPG").getImage();
        Dimension size = new Dimension(blackBackground.getWidth(null), board.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Route panel = new Route();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    @Override
    public void paintComponent(Graphics g){
        // As we learned in the last lesson,
        // the origin (0,0) is at the upper left corner.
        // x increases to the right, and y increases downward.
        // add 270 to be on board, board ends at 890
        super.paintComponent(g);

        g.drawImage(blackBackground,0,0,null);
        g.drawImage(board,blackBackground.getWidth(null)/4,0,null);

        //used to find coordinates
        g.setColor(new Color(255,0,0));
        g.drawRect(735, 434, 10, 10);
        g.fillRect(735,434,10,10);

        //size of one rectangle in a route
        g.setColor(new Color(0,0,0));
        g.drawRect(630, 400, 31, 10);
        g.fillRect(630,400,31,10);

        g.setColor(new Color(0,0,255));
        g.drawRect(580, 340, 217, 10);
        g.fillRect(580,340,217, 10);

        //Hamburg to Berlin
        g.setColor(new Color(0,255,0));
        int [] a1 = {732, 720, 909, 921};
        int [] a2 = {189, 208, 308, 289};
        g.drawPolygon(a1,a2,4);
        g.fillPolygon(a1,a2,4);

        //Hamburg to Hannover
        g.setColor(new Color(0,255,0));
        int [] a3 = {719, 697, 667, 690};
        int [] a4 = {207, 201, 321, 325};
        g.drawPolygon(a3,a4,4);
        g.fillPolygon(a3,a4,4);

        //Hannover to Berlin
        g.setColor(new Color(0,255,0));
        int [] a5 = {694, 694, 909, 909};
        int [] a6 = {320, 329, 321, 310};
        g.drawPolygon(a5,a6,4);
        g.fillPolygon(a5,a6,4);

        //Hannover to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a7 = {692, 672, 751, 771};
        int [] a8 = {338, 349, 481, 469};
        g.drawPolygon(a7,a8,4);
        g.fillPolygon(a7,a8,4);

        //Erfurt to Chyemnitz
        g.setColor(new Color(0,255,0));
        int [] a9 = {782, 781, 903, 903};
        int [] a10 = {481, 490, 502, 492};
        g.drawPolygon(a9,a10,4);
        g.fillPolygon(a9,a10,4);

        //Erfurt to Nurnburg
        g.setColor(new Color(0,255,0));
        int [] a11 = {778, 755, 758, 780};
        int [] a12 = {498, 498, 620, 619};
        g.drawPolygon(a11,a12,4);
        g.fillPolygon(a11,a12,4);

        //Nurnburg to Regensburg
        g.setColor(new Color(0,255,0));
        int [] a13 = {792, 785, 860, 866};
        int [] a14 = {624, 632, 684, 677};
        g.drawPolygon(a13,a14,4);
        g.fillPolygon(a13,a14,4);

        //Nurnburg to Munchen
        g.setColor(new Color(0,255,0));
        int [] a15 = {788, 766, 827, 848};
        int [] a16 = {637, 647, 786, 778};
        g.drawPolygon(a15,a16,4);
        g.fillPolygon(a15,a16,4);

        //Nurnburg to Augsburg
        g.setColor(new Color(0,255,0));
        int [] a17 = {763, 753, 747, 758};
        int [] a18 = {641, 641, 763, 763};
        g.drawPolygon(a17,a18,4);
        g.fillPolygon(a17,a18,4);

        //Augsburg to Munchen
        g.setColor(new Color(0,255,0));
        int [] a19 = {768, 762, 820, 825};
        int [] a20 = {771, 793, 807, 787};
        g.drawPolygon(a19,a20,4);
        g.fillPolygon(a19,a20,4);

        //Augsburg to Ulm
        g.setColor(new Color(0,255,0));
        int [] a21 = {743, 741, 713, 713};
        int [] a22 = {763, 785, 783, 762};
        g.drawPolygon(a21,a22,4);
        g.fillPolygon(a21,a22,4);

        //Munchen to country
        g.setColor(new Color(0,255,0));
        int [] a23 = {853, 845, 910, 919};
        int [] a24 = {802, 811, 873, 866};
        g.drawPolygon(a23,a24,4);
        g.fillPolygon(a23,a24,4);

        //Regensburg to new country
        g.setColor(new Color(0,255,0));
        int [] a25 = {901, 891, 958, 968};
        int [] a26 = {699, 706, 807, 801};
        g.drawPolygon(a25,a26,4);
        g.fillPolygon(a25,a26,4);

        //Leipzig to Dresden
        g.setColor(new Color(0,255,0));
        int [] a27 = {875, 872, 957, 961};
        int [] a28 = {432, 441, 471, 461};
        g.drawPolygon(a27,a28,4);
        g.fillPolygon(a27,a28,4);

        //Leipzig to Chemnitz
        g.setColor(new Color(0,255,0));
        int [] a29 = {870, 862, 904, 911};
        int [] a30 = {442, 449, 491, 484};
        g.drawPolygon(a29,a30,4);
        g.fillPolygon(a29,a30,4);

        //Magdeburg to Leipzig
        g.setColor(new Color(0,255,0));
        int [] a31 = {836, 825, 849, 859};
        int [] a32 = {366, 370, 425, 421};
        g.drawPolygon(a31,a32,4);
        g.fillPolygon(a31,a32,4);

        //Schwerin to Rostock
        g.setColor(new Color(0,255,0));
        int [] a33 = {841, 834, 798, 805};
        int [] a34 = {126, 121, 169, 175};
        g.drawPolygon(a33,a34,4);
        g.fillPolygon(a33,a34,4);

        //Chemnitz to Dresden
        g.setColor(new Color(0,255,0));
        int [] a35 = {954, 958, 930, 926};
        int [] a36 = {474, 482, 497, 486};
        g.drawPolygon(a35,a36,4);
        g.fillPolygon(a35,a36,4);

        //Ulm to Lindau
        g.setColor(new Color(0,255,0));
        int [] a37 = {699, 691, 674, 684};
        int [] a38 = {787, 785, 842, 845};
        g.drawPolygon(a37,a38,4);
        g.fillPolygon(a37,a38,4);

        // Ulm to Stuttgart
        g.setColor(new Color(0,255,0));
        int [] a39 = {649, 635, 684, 699};
        int [] a40 = {721, 739, 774, 755};
        g.drawPolygon(a39,a40,4);
        g.fillPolygon(a39,a40,4);

        //Lindau to new country
        g.setColor(new Color(0,255,0));
        int [] a41 = {693, 689, 744, 748};
        int [] a42 = {857, 865, 886, 875};
        g.drawPolygon(a41,a42,4);
        g.fillPolygon(a41,a42,4);

        //Lindau to Konstanz
        g.setColor(new Color(0,255,0));
        int [] a43 = {640, 637, 665, 667};
        int [] a44 = {841, 850, 857, 848};
        g.drawPolygon(a43,a44,4);
        g.fillPolygon(a43,a44,4);

        //Konstanz to Stuttgart
        g.setColor(new Color(0,255,0));
        int [] a45 = {633, 623, 620, 631};
        int [] a46 = {741, 741, 832, 832};
        g.drawPolygon(a45,a46,4);
        g.fillPolygon(a45,a46,4);

        //Konstanz to Freiburg
        g.setColor(new Color(0,255,0));
        int [] a47 = {611, 613, 554, 552};
        int [] a48 = {845, 835, 820, 831};
        g.drawPolygon(a47,a48,4);
        g.fillPolygon(a47,a48,4);

        //Konstanz to new country
        g.setColor(new Color(0,255,0));
        int [] a49 = {612, 619, 595, 589};
        int [] a50 = {848, 856, 874, 866};
        g.drawPolygon(a49,a50,4);
        g.fillPolygon(a49,a50,4);

        //Freiburg to Stuttgart
        g.setColor(new Color(0,255,0));
        int [] a51 = {620, 612, 553, 559};
        int [] a52 = {744, 737, 808, 815};
        g.drawPolygon(a51,a52,4);
        g.fillPolygon(a51,a52,4);

        //Freiburg to Karlsruhe
        g.setColor(new Color(0,255,0));
        int [] a53 = {575, 566, 538, 547};
        int [] a54 = {726, 724, 811, 813};
        g.drawPolygon(a53,a54,4);
        g.fillPolygon(a53,a54,4);

        //Freiburg to France
        g.setColor(new Color(0,255,0));
        int [] a55 = {525, 527, 469, 467};
        int [] a56 = {824, 814, 800, 811};
        g.drawPolygon(a55,a56,4);
        g.fillPolygon(a55,a56,4);

        //Karlsruhe to Stuttgart
        g.setColor(new Color(0,255,0));
        int [] a57 = {587, 584, 611, 614};
        int [] a58 = {714, 724, 731, 722};
        g.drawPolygon(a57,a58,4);
        g.fillPolygon(a57,a58,4);

        //Karlsruhe to Mannheim
        g.setColor(new Color(0,255,0));
        int [] a59 = {576, 566, 566, 576};
        int [] a60= {672, 672, 700, 700};
        g.drawPolygon(a59,a60,4);
        g.fillPolygon(a59,a60,4);

        //Karlsruhe to France
        g.setColor(new Color(0,255,0));
        int [] a61 = {560, 555, 502, 507};
        int [] a62 = {725, 717, 745, 754};
        g.drawPolygon(a61,a62,4);
        g.fillPolygon(a61,a62,4);

        //Mannheim to Stuttgart
        g.setColor(new Color(0,255,0));
        int [] a63 = {599, 580, 616, 634};
        int [] a64 = {658, 672, 721, 707};
        g.drawPolygon(a63,a64,4);
        g.fillPolygon(a63,a64,4);

        //Mainz to Mannheim
        g.setColor(new Color(0,255,0));
        int [] a65 = {569, 547, 559, 579 };
        int [] a66 = {614, 624, 649, 641};
        g.drawPolygon(a65,a66,4);
        g.fillPolygon(a65,a66,4);

        //Mannheim to Saerbrucken
        g.setColor(new Color(0,255,0));
        int [] a67 = {563, 563, 473, 472};
        int [] a68 = {657, 666, 678, 669};
        g.drawPolygon(a67,a68,4);
        g.fillPolygon(a67,a68,4);

        //Saerbrucken to France
        g.setColor(new Color(0,255,0));
        int [] a69 = {458,449,444,453};
        int [] a70 = {685,684,712,714};
        g.drawPolygon(a69,a70,4);
        g.fillPolygon(a69,a70,4);

        //Koblenz to Saerbrucken
        g.setColor(new Color(0,255,0));
        int [] a71 = {478,469,451,461};
        int [] a72 = {569,567,656,657};
        g.drawPolygon(a71,a72,4);
        g.fillPolygon(a71,a72,4);

        //Koblenz to Mainz
        g.setColor(new Color(0,255,0));
        int [] a73 = {498,485,533,547};
        int [] a74= {555,574,608,590};
        g.drawPolygon(a73,a74,4);
        g.fillPolygon(a73,a74,4);

        //Mainz to Frankfurt
        g.setColor(new Color(0,255,0));
        int [] a75 = {593,580,555,567};
        int [] a76 = {589,571,589,607};
        g.drawPolygon(a75,a76,4);
        g.fillPolygon(a75,a76,4);

        //Mannheim to Frankfurt
        g.setColor(new Color(0,255,0));
        int [] a77 = {617,596,582,603};
        int [] a78 = {595,590,648,652};
        g.drawPolygon(a77,a78,4);
        g.fillPolygon(a77,a78,4);

        //Frankfurt to Wurzburg
        g.setColor(new Color(0,255,0));
        int [] a79 = {621,612,668,676};
        int [] a80 = {569,590,613,591};
        g.drawPolygon(a79,a80,4);
        g.fillPolygon(a79,a80,4);

        //Wurzburg to Nurnburg
        g.setColor(new Color(0,255,0));
        int [] a81 = {700,692,748,757};
        int [] a82 = {600,621,643,622};
        g.drawPolygon(a81,a82,4);
        g.fillPolygon(a81,a82,4);

        //Mainz to Saerbrucken
        g.setColor(new Color(0,255,0));
        int [] a83 = {545,540,464,469};
        int [] a84 = {619,610,661,668};
        g.drawPolygon(a83,a84,4);
        g.fillPolygon(a83,a84,4);

        //Koblenz to Koln
        g.setColor(new Color(0,255,0));
        int [] a85 = {477,455,463,485};
        int [] a86 = {512,519,546,540};
        g.drawPolygon(a85,a86,4);
        g.fillPolygon(a85,a86,4);

        //Frankfurt to Koln
        g.setColor(new Color(0,255,0));
        int [] a87 = {490,477,582,594};
        int [] a88 = {488,508,570,550};
        g.drawPolygon(a87,a88,4);
        g.fillPolygon(a87,a88,4);

        //Koln to Desseldorf
        g.setColor(new Color(0,255,0));
        int [] a89 = {485,451,450,484};
        int [] a90 = {451,451,481,481};
        g.drawPolygon(a89,a90,4);
        g.fillPolygon(a89,a90,4);

        //Dusseldorf to Dortmund
        g.setColor(new Color(0,255,0));
        int [] a91 = {518,505,476,490};
        int [] a92 = {434,402,415,446};
        g.drawPolygon(a91,a92,4);
        g.fillPolygon(a91,a92,4);

        //Dusseldorf to new country
        g.setColor(new Color(0,255,0));
        int [] a93 = {440,430,461,470};
        int [] a94 = {336,340,425,421};
        g.drawPolygon(a93,a94,4);
        g.fillPolygon(a93,a94,4);

        //Dortmund to Munser
        g.setColor(new Color(0,255,0));
        int [] a95 = {541,520,512,534};
        int [] a96 = {374,369,399,402};
        g.drawPolygon(a95,a96,4);
        g.fillPolygon(a95,a96,4);

        //Munster to new country
        g.setColor(new Color(0,255,0));
        int [] a97 = {517,522,466,462};
        int [] a98 = {356,346,326,334};
        g.drawPolygon(a97,a98,4);
        g.fillPolygon(a97,a98,4);

        //Munster to Emden
        g.setColor(new Color(0,255,0));
        int [] a99 = {507,497,528,537};
        int [] a100 = {223,225,341,340};
        g.drawPolygon(a99,a100,4);
        g.fillPolygon(a99,a100,4);

        //Munster to Bremen
        g.setColor(new Color(0,255,0));
        int [] a101 = {601,592,541,549};
        int [] a102 = {265,262,336,342};
        g.drawPolygon(a101,a102,4);
        g.fillPolygon(a101,a102,4);

        //Bremen to Emden
        g.setColor(new Color(0,255,0));
        int [] a103 = {595,599,513,509};
        int [] a104 = {247,237,209,218};
        g.drawPolygon(a103,a104,4);
        g.fillPolygon(a103,a104,4);

        //Emden to new country
        g.setColor(new Color(0,255,0));
        int [] a105 = {491,484,445,452};
        int [] a106 = {223,215,262,269};
        g.drawPolygon(a105,a106,4);
        g.fillPolygon(a105,a106,4);

        //Hamburg to Kiel
        g.setColor(new Color(0,255,0));
        int [] a107 = {708,686,697,718};
        int [] a108 = {121,124,183,179};
        g.drawPolygon(a107,a108,4);
        g.fillPolygon(a107,a108,4);

        //Bremen to Bremerhaven
        g.setColor(new Color(0,255,0));
        int [] a109 = {609,599,602,612};
        int [] a110 = {206,206,236,235};
        g.drawPolygon(a109,a110,4);
        g.fillPolygon(a109,a110,4);

        //Bremerhaven to Kiel
        g.setColor(new Color(0,255,0));
        int [] a111 = {684,677,610,616};
        int [] a112 = {123,115,177,183};
        g.drawPolygon(a111,a112,4);
        g.fillPolygon(a111,a112,4);

        //Berlin to Dresden
        g.setColor(new Color(0,255,0));
        int [] a113 = {937,953,964,968,969,966,976,980,979,974,963,947};
        int [] a114 = {317,341,370,400,431,460,461,432,400,367,337,310};
        g.drawPolygon(a113,a114,12);
        g.fillPolygon(a113,a114,12);

        //Berlin to Leipzig
        g.setColor(new Color(0,255,0));
        int [] a115 = {928,924,865,873,935,938};
        int [] a116 = {321,350,421,428,355,322};
        g.drawPolygon(a115,a116,6);
        g.fillPolygon(a115,a116,6);

        //Berlin to Magdeburg
        g.setColor(new Color(0,255,0));
        int [] a117 = {917,897,837,838,899,906,925};
        int [] a118 = {318,339,350,360,350,346,324};
        g.drawPolygon(a117,a118,7);
        g.fillPolygon(a117,a118,7);

        //Berlin to Schwerin
        g.setColor(new Color(0,255,0));
        int [] a119 = {919,904,883,860,835,807,811,839,866,890,911,928};
        int [] a120 = {286,261,237,218,201,191,181,190,208,229,254,282};
        g.drawPolygon(a119,a120,12);
        g.fillPolygon(a119,a120,12);

        //Berlin to Rostock
        g.setColor(new Color(0,255,0));
        int [] a121 = {930,929,922,911,896,876,852,859,883,905,920,932,940,940};
        int [] a122 = {281,252,223,194,167,144,126,118,136,161,189,219,251,282};
        g.drawPolygon(a121,a122,14);
        g.fillPolygon(a121,a122,14);

        //Schwerin to Hamburg
        g.setColor(new Color(0,255,0));
        int [] a123 = {777,750,727,720,749,781};
        int [] a124 = {184,171,188,181,160,175};
        g.drawPolygon(a123,a124,6);
        g.fillPolygon(a123,a124,6);

        //Schwerin to Kiel
        g.setColor(new Color(0,255,0));
        int [] a125 = {782,762,737,710,716,743,769,791};
        int [] a126 = {172,151,133,121,110,124,142,165};
        g.drawPolygon(a125,a126,8);
        g.fillPolygon(a125,a126,8);
        
        //Rostock to Kiel
        g.setColor(new Color(0,255,0));
        int [] a127 = {831,802,772,741,713,709,739,772,805,834};
        int [] a128 = {110,101,97 ,100,108,100,90 ,87 ,91 ,101};
        g.drawPolygon(a127,a128,10);
        g.fillPolygon(a127,a128,10);

        //Kiel to Denmark
        g.setColor(new Color(0,255,0));
        int [] a129 = {698,710,686,693,716,720,708};
        int [] a130 = {93 ,65 ,47 ,40 ,56 ,70 ,97};
        g.drawPolygon(a129,a130,7);
        g.fillPolygon(a129,a130,7);

        //Bremerhaven to Denmark
        g.setColor(new Color(0,255,0));
        int [] a131 = {606,602,605,614,628,648,640,619,604,595,593,596};
        int [] a132 = {179,150,119,89 ,62 ,41 ,35 ,57 ,86 ,118,150,180};
        g.drawPolygon(a131,a132,12);
        g.fillPolygon(a131,a132,12);

        //Beremerhaven to Emden
        g.setColor(new Color(0,255,0));
        int [] a133 = {588,561,531,510,502,526,559,567,593};
        int [] a134 = {190,176,181,203,197,172,166,167,180};
        g.drawPolygon(a133,a134,9);
        g.fillPolygon(a133,a134,9);

        //Bremerhaven to Hamburg
        g.setColor(new Color(0,255,0));
        int [] a135 = {626,648,664,696,698,669,649,619};
        int [] a136 = {193,173,189,197,186,180,159,186};
        g.drawPolygon(a135,a136,8);
        g.fillPolygon(a135,a136,8);

        //Bremen to Hamburg
        g.setColor(new Color(0,255,0));
        int [] a137 = {621,680,688,695,685,678,618};
        int [] a138 = {253,237,229,202,199,227,243};
        g.drawPolygon(a137,a138,7);
        g.fillPolygon(a137,a138,7);

        //Bremen to Hannover
        g.setColor(new Color(0,255,0));
        int [] a139 = {606,625,636,665,665,636,617};
        int [] a140 = {261,319,325,326,316,314,257};
        g.drawPolygon(a139,a140,7);
        g.fillPolygon(a139,a140,7);

        //Munster to Hannover
        g.setColor(new Color(0,255,0));
        int [] a141 = {544,575,606,635,664,663,632,602,575,546};
        int [] a142 = {365,371,355,344,338,329,334,346,361,355};
        g.drawPolygon(a141,a142,10);
        g.fillPolygon(a141,a142,10);

        //Magdeburg to Hannover
        g.setColor(new Color(0,255,0));
        int [] a143 = {816,786,751,719,696,702,724,753,784,813};
        int [] a144 = {365,374,373,360,340,333,352,363,363,356};
        g.drawPolygon(a143,a144,10);
        g.fillPolygon(a143,a144,10);

        //Leipzig to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a145 = {849,819,793,781,772,785,816,849};
        int [] a146 = {438,435,451,479,476,445,425,429};
        g.drawPolygon(a145,a146,8);
        g.fillPolygon(a145,a146,8);

        //Hannover to Kassel
        g.setColor(new Color(0,255,0));
        int [] a147 = {671,667,667,671,649,645,645,649};
        int [] a148 = {346,376,407,436,437,407,375,345};
        g.drawPolygon(a147,a148,8);
        g.fillPolygon(a147,a148,8);

        //Kassel to Dortmund
        g.setColor(new Color(0,255,0));
        int [] a149 = {648,618,584,551,527,534,556,585,616,645};
        int [] a150 = {451,460,461,449,429,421,440,450,451,442};
        g.drawPolygon(a149,a150,10);
        g.fillPolygon(a149,a150,10);

        //Kassel to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a151 = {755,723,687,671,680,695,724,753};
        int [] a152 = {494,502,489,462,456,481,493,484};
        g.drawPolygon(a151,a152,8);
        g.fillPolygon(a151,a152,8);

        //Kassel to Frankfurt
        g.setColor(new Color(0,255,0));
        int [] a153 = {669,670,662,638,612,606,600,596,621,640,647,646,657,658};
        int [] a154 = {463,494,528,555,573,563,564,556,538,516,485,455,456,463};
        g.drawPolygon(a153,a154,14);
        g.fillPolygon(a153,a154,14);

        //Saerbrucken to Karlsruhe
        g.setColor(new Color(0,255,0));
        int [] a155 = {464,488,522,553,553,523,492,472};
        int [] a156 = {687,709,716,714,704,706,700,680};
        g.drawPolygon(a155,a156,8);
        g.fillPolygon(a155,a156,8);

        //Freiburg to newCountry
        g.setColor(new Color(0,255,0));
        int [] a157 = {525,503,530,539,517,533};
        int [] a158 = {833,867,894,886,865,838};
        g.drawPolygon(a157,a158,6);
        g.fillPolygon(a157,a158,6);

        //Lindau to newCountry
        g.setColor(new Color(0,255,0));
        int [] a159 = {667,646,617,617,647,654,674};
        int [] a160 = {863,884,886,896,895,891,869};
        g.drawPolygon(a159,a160,7);
        g.fillPolygon(a159,a160,7);

        //Munchen to Regensburg
        g.setColor(new Color(0,255,0));
        int [] a161 = {851,879,884,896,898,891,880,886,874,848};
        int [] a162 = {792,779,773,746,738,711,712,741,769,784};
        g.drawPolygon(a161,a162,10);
        g.fillPolygon(a161,a162,10);

        //Regensburg to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a163 = {868,868,860,847,829,807,781,787,813,837,855,870,878,878};
        int [] a164 = {684,623,594,567,540,520,505,496,512,534,561,590,622,684};
        g.drawPolygon(a163,a164,14);
        g.fillPolygon(a163,a164,14);

        //Regensburg to Chemnitz
        g.setColor(new Color(0,255,0));
        int [] a165 = {880,879,883,906,912,891,890};
        int [] a166 = {683,531,522,504,511,531,684};
        g.drawPolygon(a165,a166,7);
        g.fillPolygon(a165,a166,7);

        //Regensburg to Dresden
        g.setColor(new Color(0,255,0));
        int [] a167 = {893,909,922,932,961,970,942,931,918,901};
        int [] a168 = {687,662,633,604,485,487,606,637,666,692};
        g.drawPolygon(a167,a168,10);
        g.fillPolygon(a167,a168,10);
        
        //Lindau to Munchen
        g.setColor(new Color(0,255,0));
        int [] a169 = {692,722,754,784,815,841,835,810,782,752,722,692};
        int [] a170 = {854,856,853,846,833,817,809,824,836,844,847,844};
        g.drawPolygon(a169,a170,12);
        g.fillPolygon(a169,a170,12);
    }
