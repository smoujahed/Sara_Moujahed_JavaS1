package com.trilogyed;

public class ModulusAnimation {
    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<168; i++ )
        {
            if ( i%21 == 0 )
                System.out.print("  This is a marquee! \r");
            else if ( i%21 == 1 )
                System.out.print(" ! This is a marquee \r");
            else if ( i%21 == 2 )
                System.out.print(" e! This is a marque \r");
            else if ( i%21 == 3 )
                System.out.print(" e! This is a marque \r");
            else if ( i%21 == 4 )
                System.out.print(" ee! This is a marqu \r");
            else if ( i%21 == 5 )
                System.out.print(" uee! This is a marq \r");
            else if ( i%21 == 6 )
                System.out.print(" quee! This is a mar \r");
            else if ( i%21 == 7 )
                System.out.print(" rquee! This is a ma \r");
            else if ( i%21 == 8 )
                System.out.print(" arquee! This is a m \r");
            else if ( i%21 == 9 )
                System.out.print(" marquee! This is a  \r");
            else if ( i%21 == 10 )
                System.out.print("  marquee! This is a \r");
            else if ( i%21 == 11 )
                System.out.print(" a marquee! This is  \r");
            else if ( i%21 == 12 )
                System.out.print("  a marquee! This is \r");
            else if ( i%21 == 13 )
                System.out.print(" s a marquee! This i \r");
            else if ( i%21 == 14 )
                System.out.print(" is a marquee! This  \r");
            else if ( i%21 == 15 )
                System.out.print("  is a marquee! This \r");
            else if ( i%21 == 16 )
                System.out.print(" s is a marquee! Thi \r");
            else if ( i%21 == 17 )
                System.out.print(" is is a marquee! Th \r");
            else if ( i%21 == 18 )
                System.out.print(" his is a marquee! T \r");
            else if ( i%21 == 19 )
                System.out.print(" This is a marquee!  \r");
            else if ( i%21 == 20 )
                System.out.print("  This is a marquee! \r");


                Thread.sleep(200);
        }

    }
}
