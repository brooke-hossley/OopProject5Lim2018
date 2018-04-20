import java.util.ArrayList;
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

    //The color of the route
    protected ArrayList<RouteColor> color; 

    //if there are two possibilities for this route in different colors
    protected boolean twoColors; 

    //polygon to use as bounds for mouse hover and click
    protected Polygon routeShape;

    //player's color once occupying the route
    protected Color occupiedByColor;

    //holds locations of trains occypying route once it's claimed by a player
    protected Polygon[] occupyingTrains;

    //protected boolean doubleTrack;//If the route has double or triple capacity
    //protected boolean tripleTrack;
    private ArrayList<String> cities = new ArrayList<String>(2);
    //private ArrayList<RouteColor> colors = new ArrayList<RouteColor>();

    private static Image board, blackBackground;

    public Route(int len, RouteColor rcolor, boolean twoCol){
        length = len;
        //color = rcolor;

    }

    public Route(String firstCity, String secondCity)
    {
        //cities.add(firstCity);
        //cities.add(secondCity);
        String cityOneName = firstCity;
        String cityTwoName = secondCity;

        if (cityOneName.equals("Danemark"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
            }
            else if(cityTwoName.equals("Bremerhaven"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityOneName.equals("Kiel"))
        {
            if(cityTwoName.equals("Rostock"))
            {
                length = 5;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Scwerin"))
            {
                length = 5;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Danemark"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Rostock"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("Schwerin"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Rostock"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 5;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityOneName.equals("Hamburg"))
        {
            if(cityTwoName.equals("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 4;
                color.add(RouteColor.RED);
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Kiel"))
            {
                length = 2;
                color.add(RouteColor.PINK);
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Bremerhaven"))
        {
            if(cityTwoName.equals("Danemark"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Kiel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Emden"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Emden"))
        {
            if(cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 4;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Niederlande"))
            {
                length = 2;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityOneName.equals("Bremen"))
        {
            if(cityTwoName.equals("Bremerhaven"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Emden"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
        }
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

    protected RouteColor getRouteColor(){
        return null;   
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
        g.drawRect(1017, 434, 10, 30);
        g.fillRect(1017,434,10,30);

        //size of one rectangle in a route
        g.setColor(new Color(0,0,0));
        g.drawRect(757, 400, 31, 10);
        g.fillRect(757,400,31,10);

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

    }
    // protected boolean isDouble(){
    // return doubleTrack;   
    // }

    // protected boolean isTriple(){
    // return tripleTrack;   
    // }
}
