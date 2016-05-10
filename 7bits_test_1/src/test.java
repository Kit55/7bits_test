import java.io.*;

public class test{
    public static void main(String[] args) throws IOException{

        File f = new File("files.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));

        String line;
        String text="";
        int tabLvl=0, bracketCounter=0;
        while ((line = fin.readLine()) != null) {
            do {
                line = line.replaceAll("  "," ");
            }
            while (line.lastIndexOf("  ")!=-1);
            text = text+line;
        }
        for (int i=0;i<text.length();i++) {
            if (text.charAt(i)==' ')
                if (text.charAt(i-1)=='}'||text.charAt(i-1)=='{'||text.charAt(i-1)==';')
                    continue;
            bracketCounter += text.charAt(i)=='(' ? 1 : 0;
            bracketCounter -= text.charAt(i)==')' ? 1 : 0;

            if ((text.charAt(i)=='}'||text.charAt(i)=='{'||text.charAt(i)==';')&&bracketCounter==0){
                if (text.charAt(i)==';')
                {
                    if (text.charAt(i+2)=='}')
                        System.out.print (text.charAt(i));
                    else
                    {
                        System.out.print (text.charAt(i));
                        newLine(tabLvl);
                    }

                }
                else if (text.charAt(i)=='{')
                {
                    System.out.print (text.charAt(i));
                    tabLvl+=1;
                    newLine(tabLvl);

                }
                else if (text.charAt(i)=='}')
                {
                    tabLvl-=1;
                    newLine(tabLvl);
                    System.out.print (text.charAt(i));
                    newLine(tabLvl);
                }
            }
            else
                System.out.print (text.charAt(i));
        }
    }

    public static void newLine(int _tabLvl) {
        System.out.println ();
        for (int i=0;i<_tabLvl;i++)
            System.out.print("    ");
    }
}