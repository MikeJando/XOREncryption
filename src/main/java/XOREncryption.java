import java.io.*;

public class XOREncryption
{
    public static void main(String[] args)
    {
        File a = new File("data.txt");
        File b = new File("key.txt");

        try
        {
            FileInputStream data = new FileInputStream(a);
            FileInputStream key = new FileInputStream(b);

            byte[] arrData = new byte[(int)a.length()];
            byte[] arrKey = new byte[(int)b.length()];

            int intData = data.read(arrData);
            int intKey = key.read(arrKey);

            for(int i = 0; i<arrData.length;i++)
            {
                int z = (int)arrData[i] ^ (int)arrKey[i % arrKey.length];

                arrData[i] = (byte) z;
            }

            FileOutputStream out = new FileOutputStream("data_encrypt.txt");

            out.write(arrData);

            data.close();
            key.close();
            out.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.print("No File.");
        }
        catch(IOException ex)
        {
            System.out.print("Error reading file.");
        }
    }
}
