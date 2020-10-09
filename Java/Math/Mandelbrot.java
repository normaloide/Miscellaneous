import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Mandelbrot {
    public static void main(String[] args) throws IOException {
        try {
            final int width = 720;            //change width of the image
            final int height = 720;           //change height of the image
            final int maxit = 100000;         //change number of iterations
            final double centering = 2.0;     //change to move the image
            final double zoom = 5;

            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    double re = (x - width/centering) * zoom/width;
                    double im = (y - height/2.0) * zoom/width;
                    double xx = 0;
                    double yy = 0;
                    int it = 0;
                    while(xx * xx + yy * yy <= zoom && it < maxit) {
                        double xx2 = xx*xx - yy*yy + re;
                        yy = 2.0*xx*yy + im;
                        xx = xx2;
                        it++;
                    }

                    if (it < maxit && it > 0) {
                        int i = it % 16;
                        switch(i) {
                            case 0:
                                bi.setRGB(x, y, new Color(66, 30, 15).getRGB());
                                break;

                            case 1:
                                bi.setRGB(x, y, new Color(25, 7, 26).getRGB());
                                break;

                            case 2:
                                bi.setRGB(x, y, new Color(9, 1, 47).getRGB());
                                break;

                            case 3:
                                bi.setRGB(x, y, new Color(4, 4, 73).getRGB());
                                break;

                            case 4:
                                bi.setRGB(x, y, new Color(0, 7, 100).getRGB());
                                break;

                            case 5:
                                bi.setRGB(x, y, new Color(12, 44, 138).getRGB());
                                break;

                            case 6:
                                bi.setRGB(x, y, new Color(24, 82, 177).getRGB());
                                break;

                            case 7:
                                bi.setRGB(x, y, new Color(57, 125, 209).getRGB());
                                break;

                            case 8:
                                bi.setRGB(x, y, new Color(134, 181, 229).getRGB());
                                break;

                            case 9:
                                bi.setRGB(x, y, new Color(211, 236, 248).getRGB());
                                break;

                            case 10:
                                bi.setRGB(x, y, new Color(241, 233, 191).getRGB());
                                break;

                            case 11:
                                bi.setRGB(x, y, new Color(248, 201, 95).getRGB());
                                break;

                            case 12:
                                bi.setRGB(x, y, new Color(255, 170, 0).getRGB());
                                break;

                            case 13:
                                bi.setRGB(x, y, new Color(204, 128, 0).getRGB());
                                break;

                            case 14:
                                bi.setRGB(x, y, new Color(153, 87, 0).getRGB());
                                break;

                            case 15:
                                bi.setRGB(x, y, new Color(106, 52, 3).getRGB());
                                break;

                            default:
                                break;
                        }
                    }

                    else {
                        bi.setRGB(x, y, new Color(0, 0, 0).getRGB());
                    }
                }
            }

            ImageIO.write(bi, "png", new File("mandelbrot.png"));
        } 

        catch (IOException e) {
            System.out.print("error");
        }
    }
}
