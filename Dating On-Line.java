import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		int i, right, left;
        double area = 0;
        double pi = 3.141592653;
        double sine;
        int n;
        
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String line = br.readLine();
		while (line != null)
		{
			n = Integer.parseInt(line);
			int[] array = new int[n];
			area = 0;
			sine = 0;
            
			line = br.readLine();
			StringTokenizer tokens = new StringTokenizer(line, " ");
            
            i = 0;
            while(tokens.hasMoreTokens())
            {
                String str = tokens.nextToken();
                array[i] = Integer.parseInt(str);
                i++;
            }
            
            Arrays.sort(array);
            right = array[0];
            left = array[1];
            
            sine = Math.sin(2 * pi / n) / 2;
            area = area + (left * right * sine);
            
            for(i = 2; i < array.length; i++)
            {
                if (right < left)
                {
                    area = area + (right * array[i] * sine);
                    right = array[i];
                }
                else
                {
                    area = area + (left * array[i] * sine);
                    left = array[i];
                }
            }
            area = area + (left * right * sine);
            area = Round(area, 3);
            System.out.println(area);
			line = br.readLine();
		}
	}
    
	public static double Round(double initialValue, int numberDecimals)
	{
        double wholeNumber, result;
        result = initialValue;
        wholeNumber = Math.floor(result);
        result = (result - wholeNumber) * Math.pow(10, numberDecimals);
        result = Math.round(result);
        result = (result / Math.pow(10, numberDecimals)) + wholeNumber;
        return result;
    }
}
