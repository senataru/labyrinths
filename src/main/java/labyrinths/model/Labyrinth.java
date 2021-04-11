package labyrinths.model;

import static labyrinths.model.Type.WALL;

public class Labyrinth {
    Type[][] table;
    Graph graph;
    int width;
    int height;
    Labyrinth(int width, int height){
        table= new Type[height+2][width+2];
        this.width=width+2;
        this.height=height+2;
        for(int i=0; i<height+2; i++){
            for(int j=0; j<width+2; j++){
                if(i==0||j==0)
                    table[i][j]= Type.WALL;
                else
                    table[i][j]=Type.FREE;
            }
        }
        graph=new Graph(width, height, table);
    }
    Result perform(String algorithm){
        return null;
    }
    Result getDefault(){
        Result res=new Result();
        for(int i=2; i<width-1; i+=2){
            for(int j=1; j<height-1; j++){
                if(!((j==1&&i%4==0)||(j==height-1&&i%4==2))){
                    table[i][j]=Type.WALL;
                    graph.removeVertex(new Field(i, j, WALL));
                    res.add(new Field(i-1, j-1, WALL));
                }
            }
        }
        return res;
    }
}