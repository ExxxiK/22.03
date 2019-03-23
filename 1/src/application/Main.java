package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Animation example");
			Group root = new Group();
			Scene myScene = new Scene(root);		
			primaryStage.setScene(myScene);
			
			Canvas canvas = new Canvas(512,512);
			root.getChildren().add(canvas);
			
			GraphicsContext gc =canvas.getGraphicsContext2D();
			
			Image car =  new Image("machina.jpg");
			 AnimatedImage road = new AnimatedImage();
		        Image[] imageArray = new Image[3];
		        for(int i=0;i<3;i++) {
		        	imageArray[i] = new Image("road"+i+".jpg");
		        }
		        road.frames = imageArray;
		        road.duration = 0.1;
		        
		        final long startNanoTime = System.nanoTime();
		        
		        new AnimationTimer()
		        {
		            public void handle(long currentNanoTime)
		            {
		                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
		                gc.drawImage(road.getFrame(t), 0, 0);
		                gc.drawImage(car, 0, 0);
	
		            }
		        }.start();
		        
		        
		        
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
