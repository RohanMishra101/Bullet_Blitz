package main;

import Entity.Entity;

public class CollisonChecker {
    GamePanel gp;
    public CollisonChecker(GamePanel gp){
        this.gp = gp;
    }

    public void CheckTile(Entity entity) {
        int entityLeftCol = entity.posX / gp.tileSize;
        int entityRightCol = (entity.posX + entity.solidArea.width - 1) / gp.tileSize;
        int entityTopRow = entity.posY / gp.tileSize;
        int entityBottomRow = (entity.posY + entity.solidArea.height - 1) / gp.tileSize;

        int tileNum1, tileNum2;

        if (gp.KeyH.up) {
            if (entityTopRow >= 0 && entityLeftCol >= 0 && entityTopRow < gp.tileN.mapTileNum.length && entityLeftCol < gp.tileN.mapTileNum[0].length) {
                tileNum1 = gp.tileN.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileN.mapTileNum[entityRightCol][entityTopRow];
                if (tileNum1 >= 0 && tileNum1 < gp.tileN.tilesBG.length && tileNum2 >= 0 && tileNum2 < gp.tileN.tilesBG.length) {
                    if (gp.tileN.tilesBG[tileNum1].collison || gp.tileN.tilesBG[tileNum2].collison) {
                        entity.collisionOn = true;
                        System.out.println("Collision Detected");
                    }
                }
            }
        } else if (gp.KeyH.down) {
            if (entityBottomRow >= 0 && entityLeftCol >= 0 && entityBottomRow < gp.tileN.mapTileNum.length && entityLeftCol < gp.tileN.mapTileNum[0].length) {
                tileNum1 = gp.tileN.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileN.mapTileNum[entityRightCol][entityBottomRow];
                if (tileNum1 >= 0 && tileNum1 < gp.tileN.tilesBG.length && tileNum2 >= 0 && tileNum2 < gp.tileN.tilesBG.length) {
                    if (gp.tileN.tilesBG[tileNum1].collison || gp.tileN.tilesBG[tileNum2].collison) {
                        entity.collisionOn = true;
                        System.out.println("Collision Detected");
                    }
                }
            }
        }else{
            entity.collisionOn = false;
        }
    }

}
