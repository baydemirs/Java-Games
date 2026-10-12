import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JavaGamesSmoke {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
    private static void expectFailure(Method loader, String name, String expected) throws Exception {
        try {
            loader.invoke(null, name);
            throw new AssertionError("Expected image validation failure");
        } catch (InvocationTargetException error) {
            check(error.getCause() instanceof IllegalStateException, "Wrong exception type");
            check(error.getCause().getMessage().startsWith(expected), "Wrong diagnostic");
        }
    }
    public static void main(String[] args) throws Exception {
        String entryPoint = args[0];
        for (int i = 1; i < args.length; i++) {
            URL resource = JavaGamesSmoke.class.getResource("/images/" + args[i]);
            check(resource != null, "Missing resource: " + args[i]);
            BufferedImage image = ImageIO.read(resource);
            check(image != null && image.getWidth() > 0 && image.getHeight() > 0, "Unreadable image");
            System.out.println("RESOURCE_PASS " + args[i] + " " + image.getWidth() + "x" + image.getHeight());
        }
        if (entryPoint.equals("App")) {
            Method loader = Class.forName("FlappyBird").getDeclaredMethod("loadImage", String.class);
            loader.setAccessible(true);
            expectFailure(loader, "/images/_missing_test.png", "Missing image resource:");
            expectFailure(loader, "/images/_invalid_test.png", "Unable to load image resource:");
            System.out.println("NEGATIVE_RESOURCE_CHECKS_PASS");
        }
        Class.forName(entryPoint).getMethod("main", String[].class).invoke(null, (Object) new String[0]);
        SwingUtilities.invokeAndWait(() -> {
            boolean found = false;
            for (Frame frame : Frame.getFrames()) {
                if (frame.isDisplayable() && frame.isVisible()) {
                    found = true;
                    System.out.println("WINDOW_PASS " + frame.getClass().getName() + " title=" + frame.getTitle() + " size=" + frame.getWidth() + "x" + frame.getHeight());
                    if (entryPoint.equals("App")) {
                        Component panel = ((JFrame) frame).getContentPane().getComponent(0);
                        for (String fieldName : new String[]{"backgroundImg", "birdImg", "topPipeImg", "bottomPipeImg"}) {
                            try {
                                Field field = panel.getClass().getDeclaredField(fieldName);
                                field.setAccessible(true);
                                Image image = (Image) field.get(panel);
                                check(image.getWidth(null) > 0 && image.getHeight(null) > 0, "FlappyBird image not loaded");
                            } catch (ReflectiveOperationException error) { throw new RuntimeException(error); }
                        }
                        for (String timerName : new String[]{"gameLoop", "placePipeTimer"}) {
                            try {
                                Field field = panel.getClass().getDeclaredField(timerName);
                                field.setAccessible(true);
                                ((Timer) field.get(panel)).stop();
                            } catch (ReflectiveOperationException error) { throw new RuntimeException(error); }
                        }
                        System.out.println("FLAPPY_ACTUAL_IMAGES_PASS");
                    }
                }
                frame.dispose();
            }
            check(found, "No visible displayable game window");
        });
        System.out.println("STARTUP_PASS " + entryPoint);
        System.exit(0);
    }
}
