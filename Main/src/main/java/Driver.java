import com.aparapi.Kernel;
import com.aparapi.internal.kernel.KernelManager;
import com.aparapi.internal.kernel.KernelManagers;
import com.aparapi.internal.kernel.KernelPreferences;
import com.aparapi.device.Device;
import java.util.List;
import static java.lang.Math.*;


public class Driver
{
    public static void main(String[] args)
    {
        final float[] input = new float[]{-6.5f, -3.5f, 3.5f, 6.5f};
        final float[] rintOutput = new float[input.length];
        final float[] roundOutput = new float[input.length];
        final float[] ceiltOutput = new float[input.length];
        final float[] floortOutput = new float[input.length];

        Kernel ker = new Kernel()
        {
            @Override
            public void run()
            {
                for (int i=0; i<4 ;i++)
                {
                    rintOutput[i] = rint(input[i]);
                    roundOutput[i] = round(input[i]);
                    ceiltOutput[i] = ceil(input[i]);
                    floortOutput[i] = floor(input[i]);
                }
            }
        };
        Device dev = KernelManager.instance().bestDevice();
        System.out.println(dev.toString());

        ker.execute(1);

        System.out.println("\nInput Vector: ");
        for (int i=0; i<input.length ;i++)
            System.out.format("%f ", input[i]);

        System.out.println("\nrint(*): ");
        for (int i=0; i<input.length ;i++)
            System.out.format("%f ", rintOutput[i]);

        System.out.println("\nround(*): ");
        for (int i=0; i<input.length ;i++)
            System.out.format("%f ", roundOutput[i]);

        System.out.println("\nceil(*): ");
        for (int i=0; i<input.length ;i++)
            System.out.format("%f ", ceiltOutput[i]);

        System.out.println("\nfloor(*): ");
        for (int i=0; i<input.length ;i++)
            System.out.format("%f ", floortOutput[i]);



    }

}
