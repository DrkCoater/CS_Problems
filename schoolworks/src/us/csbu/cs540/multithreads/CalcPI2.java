package us.csbu.cs540.multithreads;

class CalcPI2
{
   public static void main (String [] args)
   {
      MyThread2 mt = new MyThread2 ();
      mt.start ();
      while (mt.isAlive ())
        try
        {
            Thread.sleep (2); // Sleep for 2 milliseconds
        }
        catch (InterruptedException e)
        {
        }
      System.out.println ("pi = " + mt.pi);
   }
}

/**
 * This thread class calculate PI
 *
 */
class MyThread2 extends Thread
{
   boolean negative = true;
   double pi; // Initializes to 0.0, by default
   public void run ()
   {
      for (int i = 3; i < 100000; i += 2)
      {
           if (negative)
               pi -= (1.0 / i);
           else
               pi += (1.0 / i);
           negative = !negative;
      }
      pi += 1.0;
      pi *= 4.0;
      System.out.println ("Finished calculating PI");
   }
}