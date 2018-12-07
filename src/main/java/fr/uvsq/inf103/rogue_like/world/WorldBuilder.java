package fr.uvsq.inf103.rogue_like.world;

public class WorldBuilder {
    private int width;
    private int height;
    private Element[][] tiles;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Element[width][height];
    }

    private WorldBuilder construitMur(int x, int y) {
        int i=0;
        if(Math.random()<0.5){
            while((i<3)&&(x<width)){
                tiles[x][y]=Element.WALL;
                i++;
                x++;
            }
        }
        else {
            while((i<3)&&(y<height)){
                tiles[x][y]=Element.WALL;
                i++;
                y++;
            }

        }

        return this;
    }

    
    private WorldBuilder randomizeTiles() {
        //on met du sol partout
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                    tiles[x][y]=Element.FLOOR;
            }
        }
        // on met des murs a des endroits aleatoires
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if(Math.random()>=0.99){
                    this.construitMur(x,y);
                }
            }
        }

        // on met 10 dollars sur la map
        int x_random, y_random;
        for(int money=0 ; money<10 ; money++) {
            x_random=(int)(Math.random() * width);
            y_random=(int)(Math.random() * height);
            while(tiles[x_random][y_random]!=Element.FLOOR){
                x_random=(int)(Math.random() * width);
                y_random=(int)(Math.random() * height);
            }
            tiles[x_random][y_random]=Element.MONEY;

        }

        // on met une clé (a enlever car ce sera une creature PNJ qui lui donnera
        // contre de l'argent
        /*x_random=(int)(Math.random() * width);
        y_random=(int)(Math.random() * height);
        while(tiles[x_random][y_random]!=Element.FLOOR){
            x_random=(int)(Math.random() * width);
            y_random=(int)(Math.random() * height);
        }
        tiles[x_random][y_random]=Element.KEY;*/

        // on met une porte
        x_random=(int)(Math.random() * width);
        y_random=(int)(Math.random() * height);
        while(tiles[x_random][y_random]!=Element.FLOOR){
            x_random=(int)(Math.random() * width);
            y_random=(int)(Math.random() * height);
        }
        tiles[x_random][y_random]=Element.DOOR;

        // on met une arme
        x_random=(int)(Math.random() * width);
        y_random=(int)(Math.random() * height);
        int type_arme;
        while(tiles[x_random][y_random]!=Element.FLOOR){
            x_random=(int)(Math.random() * width);
            y_random=(int)(Math.random() * height);
        }
        Arme nb_armes=Arme.NB_ARMES;
        Arme arme_choisi;
        do{
            type_arme=(int)(Math.random() * nb_armes.ordinal()+1); // ordinal recupere le nombre d'enum
            arme_choisi=Arme.values()[type_arme];
        }while((arme_choisi==Arme.AUCUNE_ARME)||(arme_choisi==Arme.NB_ARMES));
        if(arme_choisi==Arme.BATTE_BASEBALL) tiles[x_random][y_random]=Element.BATTE_BASEBALL;
        else if(arme_choisi==Arme.COUTEAU) tiles[x_random][y_random]=Element.COUTEAU;
        else if(arme_choisi==Arme.EPEE) tiles[x_random][y_random]=Element.EPEE;

        // on met 2 vies sur la map
        for(int vie=0 ; vie<2 ; vie++) {
            x_random=(int)(Math.random() * width);
            y_random=(int)(Math.random() * height);
            while(tiles[x_random][y_random]!=Element.FLOOR){
                x_random=(int)(Math.random() * width);
                y_random=(int)(Math.random() * height);
            }
            tiles[x_random][y_random]=Element.LIFE;

        }


        return this;
    }

    public WorldBuilder makeCaves() {
    return randomizeTiles();
    }

    public World build() {
        return new World(tiles);
    }
}
