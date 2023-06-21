package main.Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Random;

public class TilesManager {
    Random randNum = new Random();
    GamePanel gp;
    public Tiles[] tilesBG;

    String filePath = "res/maps/WorldMapTest.txt";

    public int[][] mapTileNum;


    public TilesManager(GamePanel gp){
        this.gp = gp;

        tilesBG = new Tiles[8];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        File file = new File(filePath);
        getTileImg();
        if(file.length() != 0){
            loadMap();
        }else {
            setMap();
            loadMap();
        }

    }
    public void getTileImg(){
        try {
            tilesBG[0] = new Tiles();
            tilesBG[0].image = ImageIO.read(new File("res/Tiles/SpaceBackGround.png"));

            tilesBG[1] = new Tiles();
            tilesBG[1].image = ImageIO.read(new File("res/Tiles/SpaceBackGround1.png"));

            tilesBG[2] = new Tiles();
            tilesBG[2].image = ImageIO.read(new File("res/Tiles/SpaceBackGround2.png"));

            tilesBG[3] = new Tiles();
            tilesBG[3].image = ImageIO.read(new File("res/Tiles/SpaceBackGround3.png"));

            tilesBG[4] = new Tiles();
            tilesBG[4].image = ImageIO.read(new File("res/Tiles/BlankSpaceBackGround.png"));

            tilesBG[5] = new Tiles();
            tilesBG[5].image = ImageIO.read(new File("res/Tiles/SpaceBackGround4.png"));

            tilesBG[6] = new Tiles();
            tilesBG[6].image = ImageIO.read(new File("res/Tiles/SpaceBackGround5.png"));

            tilesBG[7] = new Tiles();
            tilesBG[7].image = ImageIO.read(new File("res/Tiles/CollisionBlankSpace.png"));
            tilesBG[7].collison = true;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            FileInputStream fis = new FileInputStream("res/maps/WorldMapTest.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            int col = 0;
            int row = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (col = 0; col < numbers.length && col < gp.maxWorldCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
                if (row >= gp.maxWorldRow) {
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WorldMapTest not found");
        }

    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

//        int value;
        while (worldCol<gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.posX + gp.player.screenX;
            int screenY = worldY - gp.player.posY + gp.player.screenY;

            if (worldX + (gp.tileSize*4)> gp.player.posX - gp.player.screenX &&
                    worldX - (gp.tileSize*4)< gp.player.posX + gp.player.screenX &&
                    worldY + (gp.tileSize*4)> gp.player.posY - gp.player.screenY &&
                    worldY - (gp.tileSize*4)< gp.player.posY + gp.player.screenY) {

                g2.drawImage(tilesBG[tileNum].image,screenX,screenY,gp.tileSize, gp.tileSize, null);
//                g2.drawImage();
            }
            worldCol++;


            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }


//    public void setMap(){
//        try {
//            FileWriter writer = new FileWriter("res/maps/WorldMapTest.txt");
//            for (int i=0;i<gp.maxWorldRow;i++){
//                for(int j = 0; j< gp.maxWorldCol;j++){
//                    if(i <= 5 || j <= 5){
//                        writer.write(randNum.nextInt(4,7) + " ");
//                    } else if (i > gp.maxScreenCol-5 || j >= gp.maxScreenRow-5) {
//                        writer.write(randNum.nextInt(4,7) + " ");
//                    }
//                    writer.write(randNum.nextInt(5) + " ");
//
//                }
//                writer.write(System.lineSeparator());
//            }
//            writer.close();
//        }catch (IOException e){
////            e.printStackTrace();
//            System.out.println("World not found");
//        }
//    }
    public void setMap() {
        try {
            FileWriter writer = new FileWriter("res/maps/WorldMapTest.txt");

            int[][] mapData = new int[gp.maxWorldRow][gp.maxWorldCol];

            for (int i = 0; i < gp.maxWorldRow; i++) {
                for (int j = 0; j < gp.maxWorldCol; j++) {
                    if (i == 0 || i == gp.maxWorldRow - 1 || j == 0 || j == gp.maxWorldCol - 1) {
                        mapData[i][j] = 7;
                    } else if (i <= 50 || j <= 50 || i > gp.maxWorldRow - 6 || j >= gp.maxWorldCol - 6) {
                        int rand = randNum.nextInt(4, 10);
                        if (rand >= 6) {
                            mapData[i][j] = 4;
                        } else {
                            mapData[i][j] = rand;
                        }
                    } else {
                        int rand = randNum.nextInt(10);
                        if (rand >= 7) {
                            mapData[i][j] = 4;
                        } else {
                            mapData[i][j] = randNum.nextInt(7);
                        }
                    }
                }
                writer.write(arrayToString(mapData[i]) + System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("World not found");
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}