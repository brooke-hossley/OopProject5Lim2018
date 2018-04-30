import java.util.*;
import java.awt.*;
import javax.swing.*;
/**
 * Class for City information
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class City
{
    //Name of the city
    protected String name;
    protected boolean isCountry;
    //Routes connecting to the city
    protected ArrayList<Route> connectedRoutes;
    //will be used for hover functionality over city
    protected Polygon cityShape;
    /*This array holds each of the 6 colored meeples. 
    Each time a meeple is added/subtracted, the
    location of that specific color in the array 
    is incremented or decremented */
    protected int[] meeples = new int[6]; 
    //number of total meeples in city, default is 1
    protected int meepleAmount = 1;
    /**
     * Constructor with parameters for the City class
     * 
     * @param meepleIndexes An ArrayList of Meeple indexes
     * @param nameIn The name of the city
     */
    public City(ArrayList<Integer> meepleIndexes, String nameIn)
    {
        name = nameIn;
        isCountry = false;
        connectedRoutes = new ArrayList<Route>();
        //Construct the city polygons
        if(name.equals("Augsburg")) 
        {
            int[] b1 = {628,636,637,629,620,616,616,620};
            int[] b2 = {766,772,782,788,787,782,774,766};
            cityShape = new Polygon(b1, b2, 8);
        }
        else if(name.equals("Berlin")) 
        { 
            meepleAmount = 5;
            int [] b3 = {801,810,814,810,803,795,790,794};
            int [] b4 = {290,293,301,311,314,312,303,295};
            cityShape = new Polygon(b3, b4, 8);
        }
        else if(name.equals("Bremen")) 
        { 
            int [] b5 = {479,489,492,486,476,468,469,472};
            int [] b6 = {236,239,249,257,259,251,244,239};
            cityShape = new Polygon(b5,b6,8);
        }
        else if(name.equals("Bremerhaven")) 
        { 
            int [] b7 = {474,484,487,485,476,468,463,465};
            int [] b8 = {181,184,191,201,205,202,194,186};
            cityShape = new Polygon(b7,b8,8);
        }
        else if(name.equals("Chemnitz")) 
        { 
            int [] b9 = {790,799,801,796,788,778,778,784};
            int [] b10 = {484,489,499,507,509,502,493,486};
            cityShape = new Polygon(b9,b10,8);
        }
        else if(name.equals("Danemark")) 
        { 
            isCountry = true;
            int [] b79 = {542,555,564,565,553,530,518,515,515,524,531};
            int [] b80 = {21,24,36,53,69,69,57,48,33,23,19};
            cityShape = new Polygon(b79,b80,11);
        }
        else if(name.equals("Dortmund")) 
        { 
            int [] b11 = {396,405,406,400,390,384,384,389};
            int [] b12 = {402,408,417,425,425,418,409,403};
            cityShape = new Polygon(b11,b12,8);
        }
        else if(name.equals("Dresden")) 
        { 
            int [] b13 = {843,851,854,848,839,832,831,836};
            int [] b14 = {462,466,475,483,485,479,471,464};
            cityShape = new Polygon(b13,b14,8);
        }
        else if(name.equals("Dusseldorf")) 
        { 
            int [] b15 = {342,352,355,350,342,332,331,334};
            int [] b16 = {425,428,437,447,449,443,435,429};
            cityShape = new Polygon(b15,b16,8);
        }
        else if(name.equals("Emden")) 
        { 
            int [] b17 = {370,379,382,380,372,361,358,361};
            int [] b18 = {198,202,210,217,222,218,209,202};
            cityShape = new Polygon(b17,b18,8);
        }
        else if(name.equals("Erfurt")) 
        { 
            int [] b19 = {641,650,651,646,639,630,628,631};
            int [] b20 = {475,480,488,495,497,495,485,478};
            cityShape = new Polygon(b19,b20,8);
        }
        else if(name.equals("Frankfurt")) 
        { 
            meepleAmount = 4;
            int [] b21 = {469,479,483,482,476,466,459,460};
            int [] b22 = {564,567,574,582,587,588,589,570};
            cityShape = new Polygon(b21,b22,8);
        }
        else if(name.equals("Frankreich"))
        { 
            isCountry = true;
            int [] b23 = {320,355,371,365,337,306,286,291};
            int [] b24 = {721,730,760,787,808,807,779,739};
            cityShape = new Polygon(b23,b24,8);
        }
        else if(name.equals("Freiburg")) 
        { 
            int [] b25 = {412,421,423,416,406,400,399,405};
            int [] b26 = {812,819,825,835,836,829,820,814};
            cityShape = new Polygon(b25,b26,8);
        }
        else if(name.equals("Hamburg")) 
        { 
            meepleAmount = 4;
            int [] b27 = {585,595,598,594,585,576,573,576};
            int [] b28 = {181,184,192,203,205,200,194,185};
            cityShape = new Polygon(b27,b28,8);
        }
        else if(name.equals("Hannover")) 
        { 
            int [] b29 = {549,557,561,557,547,538,537,541};
            int [] b30 = {323,326,334,342,346,340,332,326};
            cityShape = new Polygon(b29,b30,8);
        }
        else if(name.equals("Karlsruhe")) 
        { 
            int [] b31 = {444,454,457,457,448,437,431,434};
            int [] b32 = {701,704,709,717,725,724,714,706};
            cityShape = new Polygon(b31,b32,8);
        }
        else if(name.equals("Kassel")) 
        { 
            int [] b33 = {537,545,549,549,542,531,525,526};
            int [] b34 = {438,441,447,453,460,460,453,443};
            cityShape = new Polygon(b33,b34,8);
        }
        else if(name.equals("Kiel"))
        { 
            int [] b35 = {573,582,582,576,565,559,559,565};
            int [] b36 = {96,104,113,120,120,113,104,98};
            cityShape = new Polygon(b35,b36,8);
        }
        else if(name.equals("Koblenz")) 
        { 
            int [] b37 = {357,364,365,357,347,342,342,348};
            int [] b38 = {544,550,558,567,567,560,551,544};
            cityShape = new Polygon(b37,b38,8);
        }
        else if(name.equals("Koln")) 
        { 
            meepleAmount = 4;
            int [] b39 = {345,352,352,346,336,329,328,335};
            int [] b40 = {485,491,500,507,507,502,495,486};
            cityShape = new Polygon(b39,b40,8);
        }
        else if(name.equals("Konstanz")) 
        { 
            int [] b41 = {503,510,509,503,493,486,487,494};
            int [] b42 = {834,841,849,856,856,850,840,833};
            cityShape = new Polygon(b41,b42,8);
        }
        else if(name.equals("Leipzig")) 
        { 
            meepleAmount = 3;
            int [] b43 = {738,745,745,737,729,723,723,731};
            int [] b44 = {422,430,437,445,445,439,426,421};
            cityShape = new Polygon(b43,b44,8);
        }
        else if(name.equals("Lindau")) 
        { 
            int [] b45 = {556,562,562,553,547,540,540,548};
            int [] b46 = {845,854,862,868,868,862,849,843};
            cityShape = new Polygon(b45,b46,8);
        }
        else if(name.equals("Magdeburg")) 
        { 
            int [] b47 = {704,709,710,704,697,690,687,692};
            int [] b48 = {345,351,359,367,368,364,353,346};
            cityShape = new Polygon(b47,b48,8);
        }
        else if(name.equals("Mainz")) 
        { 
            int [] b49 = {430,436,436,429,419,413,413,419};
            int [] b50 = {594,601,610,617,617,610,602,595};
            cityShape = new Polygon(b49,b50,8);
        }
        else if(name.equals("Mannheim")) 
        { 
            int [] b51 = {454,461,461,454,443,438,437,443};
            int [] b52 = {647,654,662,669,669,664,654,647};
            cityShape = new Polygon(b51,b52,8);
        }
        else if(name.equals("Munchen")) 
        { 
            meepleAmount = 4;
            int [] b53 = {718,723,723,716,705,699,699,706};
            int [] b54 = {785,793,801,808,808,802,794,785};
            cityShape = new Polygon(b53,b54,8);
        }
        else if(name.equals("Munster")) 
        { 
            int [] b55 = {410,416,417,408,400,393,394,402};
            int [] b56 = {343,350,357,367,367,359,349,343};
            cityShape = new Polygon(b55,b56,8);
        }
        else if(name.equals("Niederlande")) 
        { 
            isCountry = true;
            int [] b57 = {332,351,351,335,307,290,292,309};
            int [] b58 = {264,282,308,328,330,316,277,265};
            cityShape = new Polygon(b57,b58,8);
        }
        else if(name.equals("Nurnberg")) 
        { 
            int [] b59 = {649,654,654,652,643,631,632,637};
            int [] b60 = {622,628,634,639,644,637,626,621};
            cityShape = new Polygon(b59,b60,8);
        }
        else if(name.equals("Osterreich")) 
        { 
            isCountry = true;
            int [] b61 = {864,864,624,624,773,773};
            int [] b62 = {799,907,907,859,859,799};
            cityShape = new Polygon(b61,b62,6);
        }
        else if(name.equals("Regensburg")) 
        { 
            int [] b63 = {760,766,766,758,750,743,743,750};
            int [] b64 = {687,694,701,708,708,702,693,686};
            cityShape = new Polygon(b63,b64,8);
        }
        else if(name.equals("Rostock")) 
        { 
            int [] b65 = {722,728,728,722,713,706,705,710};
            int [] b66 = {101,109,115,123,123,118,110,102};
            cityShape = new Polygon(b65,b66,8);
        }
        else if(name.equals("Saarbrucken"))
        { 
            int [] b67 = {333,340,341,331,323,318,318,325};
            int [] b68 = {661,668,677,684,684,679,668,661};
            cityShape = new Polygon(b67,b68,8);
        }
        else if(name.equals("Schweiz")) 
        { 
            isCountry = true;
            int [] b69 = {457,478,478,474,421,414,415,431};
            int [] b70 = {855,874,894,903,907,888,873,856};
            cityShape = new Polygon(b69,b70,8);
        }
        else if(name.equals("Schwerin"))
        { 
            int [] b71 = {671,678,678,672,661,654,654,660};
            int [] b72 = {171,177,187,195,195,188,178,171};
            cityShape = new Polygon(b71,b72,8);
        }
        else if(name.equals("Stuttgart"))
        { 
            meepleAmount = 3;
            int [] b73 = {508,514,514,509,498,491,491,497};
            int [] b74 = {714,721,730,738,738,731,721,714};
            cityShape = new Polygon(b73,b74,8);
        }
        else if(name.equals("Ulm"))
        { 
            int [] b75 = {578,585,585,578,571,564,561,568};
            int [] b76 = {762,768,779,786,786,783,772,763};
            cityShape = new Polygon(b75,b76,8);
        }
        else if(name.equals("Wurzburg")) 
        { 
            int [] b77 = {564,569,568,559,551,545,549,555};
            int [] b78 = {595,601,611,617,616,607,598,593};
            cityShape = new Polygon(b77,b78,8);
        }

        //Add meeples
        int indexNum;
        for (int i = 0; i < meepleAmount; i++) 
        {
            indexNum = meepleIndexes.remove(meepleIndexes.size() -1);
            meeples[indexNum]++;
        }
    }

    /**
     * Method that returns and array of colors for user 
     * to choose from when choosing Meeples
     * 
     * @return String[] An array of colors 
     */
    protected String[] getMeepleColors()
    {
        //Construt array
        ArrayList<String> meepCol = new ArrayList(5);
        for (int index = 0; index < 6; index++ ) 
        {
            int count = meeples[index]; 
            if (count > 0) 
            {
                switch (index) {
                    case 0: meepCol.add("Red"); break;
                    case 1: meepCol.add("Black"); break;
                    case 2: meepCol.add("Green"); break;
                    case 3: meepCol.add("Yellow"); break;
                    case 4: meepCol.add("Blue"); break;
                    default: meepCol.add("White");
                }
            }
        }

        String[] meepleColors = new String[meepCol.size()];
        int i = 0;
        for (String color: meepCol) {
            meepleColors[i] = color;
            i++;
        }
        return meepleColors;
    }

    /**
     * Method to remove a meeple
     * 
     * @param strColor The string version of the color to remove
     */
    protected int discardMeeple(String strColor)
    {
        int index = 0;
        switch (strColor) 
        {
            case "Red": index = 0; break;
            case "Black": index = 1; break;
            case "Green": index = 2; break;
            case "Yellow": index = 3; break;
            case "Blue": index = 4; break;
            case "White": index = 5;
        }
        meeples[index]--;
        return index;
    }

    /**
     * Method to add a route to a city
     * 
     * @param r The route to be added to the city
     */
    protected void addRoute(Route r)
    {
        connectedRoutes.add(r);
    }
}
