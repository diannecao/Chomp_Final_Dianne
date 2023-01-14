import com.sun.jdi.connect.spi.TransportService;

import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    ArrayList<Boards> losingBoard = new ArrayList<Boards>();

    ArrayList<Boards> winningBoard = new ArrayList<Boards>();
    ArrayList<Boards> AB = new ArrayList<Boards>();
    public int currentcols=0;
    public int currentrow=0;

    public MyPlayer() {
        columns = new int[10];
        MakeChomp();
    }
    public void MakeChomp() {
        boolean gameOver = false;
        losingBoard.add(new Boards(1,0,0,0,0, 0, 0, 0, 0, 0));

        int cnt = 0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<=i; j++){
                for (int k = 0; k<=j; k++) {
                    for(int l=0; l<=k; l++) {
                        for (int m = 0; m <= l; m++) {
                            for (int n = 0; n <= m; n++) {
                                for (int o = 0; o <= n; o++) {
                                    for (int p = 0; p <= o; p++) {
                                        for (int q = 0; q <= p; q++) {
                                            for (int r = 0; r <= q; r++) {
//                                                if (i == 0 && j == 0 && k == 0 && l == 0 && m == 0 && n == 0 && o == 0 && p == 0 && q == 0 && r == 0) {
//                                                    continue;
//                                                }
                                                cnt++;
                                                Organizer(i, j, k, l, m, n, o, p, q, r);
                                                AB.add(new Boards(i, j, k, l, m, n, o, p, q, r, currentcols, currentrow));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Total Number of Boards: " + cnt);
        System.out.println("Total Number of Winning Boards: " + losingBoard.size());
        System.out.println("Total Number of Losing Boards: " + winningBoard.size());
    }

    public void Organizer(int I, int J, int K, int L, int M, int N, int O, int P, int Q, int R) {
        boolean hasLosingBoard=false;
        int i = I;
        int j = J;
        int k = K;
        int l = L;
        int m = M;
        int n = N;
        int o = O;
        int pp = P;
        int q = Q;
        int r = R;

        //Starting the reducer at the tenth column:

        for(int a=r; a>=0; a--){ //10th column r
            //System.out.println("PBq1: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ o+ " "+pp+" "+q+" "+a);
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z
                        && l == losingBoard.get(p).e && m == losingBoard.get(p).f &&
                        n == losingBoard.get(p).g && o == losingBoard.get(p).h && pp == losingBoard.get(p).i &&
                        q == losingBoard.get(p).j && a == losingBoard.get(p).k) {
                    currentcols=9;
                    currentrow=a;
                    hasLosingBoard = true;
                    if(i==10 && j==1 && k==1 && l==1 && m==1 && n==1 && o==1 && pp==1 && q==1 & r==1) {
                        losingBoard.get(p).print();
                        //System.out.println("5 is making the stupid mistake: " + currentcols + " " + currentrow);
                    }
                }
            }
        }

        for(int a=q; a>=0; a--){ //9th column q
            //  //System.out.println("PBq: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ o+ " "+pp+" "+a+" "+r);
            if(a<r) {
                r = a;
            }
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z &&
                        l == losingBoard.get(p).e && m == losingBoard.get(p).f &&
                        n == losingBoard.get(p).g && o == losingBoard.get(p).h &&
                        pp == losingBoard.get(p).i && a == losingBoard.get(p).j && r == losingBoard.get(p).k) {

                    currentcols=8;
                    currentrow=a;

                    hasLosingBoard = true;
                    // //System.out.println("5 is making the stupid mistake: "+currentcols + " " + currentrow);
                }
            }

        }

        r=R;

        for(int a = pp; a>=0; a--){ //8th column pp
            ////System.out.println("PBpp: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ o+ " "+a+" "+q);
            if(a<r){
                r=a;
            }
            if(a<q){
                q=a;
            }
            //System.out.println("PBq3: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ o+ " "+a+" "+q+" "+r);
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z &&
                        l == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g &&
                        o == losingBoard.get(p).h && a == losingBoard.get(p).i && q == losingBoard.get(p).j &&
                        r == losingBoard.get(p).k) {
                    currentcols=7;
                    currentrow=a;
                    hasLosingBoard = true;
                }
            }
        }

        r=R;
        q=Q;


        for(int a = o; a>=0; a--){ //7th column o
            ////System.out.println("PBo: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ a+ " "+pp+" "+q);
            if(a<r){
                r = a;
            }
            if(a<q){
                q=a;
            }
            if(a<pp){
                pp=a;
            }
            //System.out.println("PBq5: "+i+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+ a+ " "+pp+" "+a+" "+r);
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z &&
                        l == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g &&
                        a == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j &&
                        r == losingBoard.get(p).k) {
                    currentcols=6;
                    currentrow=a;
                    hasLosingBoard = true;
                }
            }
        }
        r=R;
        q=Q;
        pp=P;

        for(int a = n; a>=0; a--){ //6th column n
            ////System.out.println("PBn: "+i+" "+j+" "+k+" "+l+" "+m+ " "+a+ " "+ o+" "+pp+" "+q);
            if(a<r){
                r=a;
            }
            if(a<q){
                q=a;
            }
            if(a<pp){
                pp=a;
            }
            if(a<o){
                o = a;
            }
            //System.out.println("PBq6: "+i+" "+j+" "+k+" "+l+" "+m+ " "+a+ " "+ o+ " "+pp+" "+q+" "+r);
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z && l == losingBoard.get(p).e && m == losingBoard.get(p).f && a == losingBoard.get(p).g && o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j && r == losingBoard.get(p).k) {
                    currentcols = 5;
                    currentrow = a;
                    hasLosingBoard = true;
                }
            }
        } //6th column ends
        r=R;
        q=Q;
        pp=P;
        o = O;

        for(int a=m; a>=0; a--){ //5th column m
            // //System.out.println("PBm: "+i+" "+j+" "+k+" "+l+" "+a+ " "+n+" "+o+" "+pp+" "+q);
            if(a<r){
                r=a;
            }
            if(a<q){
                q=a;
            }
            if(a<pp){
                pp=a;
            }
            if(a<o){
                o = a;
            }
            if(a<n){
                n = a;
            }
            //System.out.println("PBq7: "+i+" "+j+" "+k+" "+l+" "+a+ " "+n+ " "+ o+ " "+pp+" "+q+" "+r);
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z &&
                        l == losingBoard.get(p).e && a == losingBoard.get(p).f && n == losingBoard.get(p).g &&
                        o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j &&
                        r == losingBoard.get(p).k) {
                    currentcols=4;
                    currentrow=a;
                    hasLosingBoard = true;
                    if(i==10 && j==1 && k==1 && l==1 && m==1 && n==1 && o==1 && pp==1 && q==1 & r==1) {
                        losingBoard.get(p).print();

                        //System.out.println("5 is making the stupid mistake: " + currentcols + " " + currentrow);
                    }
                }
            }

        }
        r=R;
        q=Q;
        pp=P;
        o=O;
        n=N;

        for(int a=l; a>=0; a--){ //4th column l
            ////System.out.println("PBl:"+i+" "+j+" "+k+" "+a+" "+m+ " "+n+" "+o+" "+pp+" "+q);
            if(a<r){
                r=a;
            }
            if(a<q){
                q=a;
            }
            if(a<pp){
                pp=a;
            }
            if(a<o){
                o=a;
            }
            if(a<n){
                n=a;
            }
            if(a<m){
                m = a;

            }
            // //System.out.println("PB4:"+i+" "+j+" "+k+" "+a+" "+m);
            //System.out.println("PBq8: "+i+" "+j+" "+k+" "+a+" "+m+ " "+n+ " "+ o+ " "+pp+" "+q+" "+r);
            for (int p = 0; p < losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z &&
                        a == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g &&
                        o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j &&
                        r == losingBoard.get(p).k) {
                    currentcols = 3;
                    currentrow = a;
                    hasLosingBoard = true;
                }
            }

        }

        r = R;
        q = Q;
        pp = P;
        o = O;
        n = N;
        m = M;

        for(int c=k; c>=0; c--){ // 3rd column k
            ////System.out.println("PBk:"+i+" "+j+" "+c+" "+l+" "+m+ " "+n+" "+o+" "+pp+" "+q);
            if(c<r){
                r=c;
            }
            if(c<q){
                q=c;
            }
            if(c<pp){
                pp=c;
            }
            if(c<o){
                o=c;
            }
            if(c<n){
                n=c;
            }
            if(c<m) {
                m = c;
            } //else
            if(c<l){
                l = c;
            }

            for (int p = 0; p < losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && c == losingBoard.get(p).z && l == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g && o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j && r == losingBoard.get(p).k) {
                    currentcols = 2;
                    currentrow = c;
                    hasLosingBoard = true;
                }
                //}
            }
        } // end of third column reduced boards
        r = R;
        q = Q;
        pp =P;
        o = O;
        n = N;
        l = L;
        m = M;

        for(int b=j; b>=0; b--){ // second column j

            if(b<r){
                r=b;
            }
            if(b<q){
                q=b;
            }
            if(b<pp){
                pp=b;
            }
            if(b<o){
                o=b;
            }
            if(b<n){
                n = b;
            }
            if (b<m) {
                m = b;
            }
            if(b<l){
                l = b;
            } //else
            if(b<k) {
                k=b;
            }

            for (int p = 0; p < losingBoard.size(); p++) {

                if (i == losingBoard.get(p).x && b == losingBoard.get(p).y && k == losingBoard.get(p).z && l == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g && o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j && r == losingBoard.get(p).k) {
                    currentcols = 1;
                    currentrow = b;
                    hasLosingBoard = true;
                }
            }
        } // end of second column reduced boards

        r = R;
        q = Q;
        pp = P;
        o = O;
        n = N;
        l = L;
        m = M;
        k = K;

        for(int a=i; a>=1; a--){
            if(a<r){
                r=a;
            }
            if(a<q){
                q=a;
            }
            if(a<pp){
                pp=a;
            }
            if(a<o){
                o = a;
            }
            if(a<n){
                n = a;
            }
            if(a<m){
                m = a;
            } //else
            if(a<l){
                l = a;
            } //else
            if(a<k){
                k = a;
            } //else
            if(a<j){
                j = a;
            }
            // //System.out.println("PBi: "+a+" "+j+" "+k+" "+l+" "+m+ " "+n+ " "+o+" "+pp+" "+q);

            for(int p=0; p< losingBoard.size(); p++) {
                if (a == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z && l == losingBoard.get(p).e && m == losingBoard.get(p).f && n == losingBoard.get(p).g && o == losingBoard.get(p).h && pp == losingBoard.get(p).i && q == losingBoard.get(p).j && r == losingBoard.get(p).k) {
                    currentcols=0;
                    currentrow=a;
                    hasLosingBoard = true;
                }
            }
        } // end of first column reduced boards

        r = R;
        q = Q;
        pp = P;
        o = O;
        n = N;
        l = L;
        m = M;
        k = K;
        j = J;
        i = I;

        if(hasLosingBoard==false){
            losingBoard.add(new Boards(i, j, k, l, m, n, o, pp, q, r));
        } else {
            winningBoard.add(new Boards(i, j, k, l, m, n, o, pp, q, r));

        }
    }

    //add your code to return the row and the column of the chip you want to take.
    //you'll be returning a data type called Point which consists of two integers.
    public Point move(Chip[][] pBoard) {

        int count=0;

        columns = new int[10];

        for(int x=0; x<10; x++){
            for(int y=0; y<10;y++){
                if(pBoard[x][y].isAlive == true) {
                    columns[y]++;
                }
            }
        }

        int column = 0;
        int row = 0;
        row = 1;
        column = 1;
        for(int x=0;x<AB.size();x++) {
//            if(AB.get(x).x<5) {
//                AB.get(x).print();
//            }
//            for(int c=0; c<10;c++) {
//                System.out.print(columns[c] + ",");
//            }
            if(AB.get(x).x==9&& AB.get(x).y==9 && AB.get(x).z==9 && AB.get(x).e==7&& AB.get(x).f == 0 && AB.get(x).g ==0&& AB.get(x).h==0 && AB.get(x).i==0 && AB.get(x).j==0&& AB.get(x).k==0){
                System.out.print("*");
                System.out.print(x);

                AB.get(x).print();

                System.out.println("r: "+AB.get(x).myrow+" c: "+AB.get(x).mycols);
                // AB.get(x).print();
            }
            if (AB.get(x).x == columns[0] && AB.get(x).y == columns[1] && AB.get(x).z == columns[2] && AB.get(x).e == columns[3] && AB.get(x).f == columns[4] && AB.get(x).g == columns[5] && AB.get(x).h == columns[6] && AB.get(x).i == columns[7] && AB.get(x).j == columns[8] && AB.get(x).k == columns[9]) {
                System.out.println("Optimal move: "+AB.get(x).mycols + " , " + AB.get(x).myrow);
                System.out.println();
                row = AB.get(x).myrow;
                column = AB.get(x).mycols;
            }

        }

//        if(row==-1 && column == -1){
//            for(int i = columns.length-1; i>0; i--){
//                if(columns[i]>0){
//                    row = columns[i]-1;
//                    column = i;
//                }
//            }
//        }
//        for(int c=0; c<10;c++){
//            System.out.print(columns[c]+",");
//            // columns[c]=0;
//        }


        gameBoard = pBoard;


        //System.out.println("row= "+row+" "+ "col ="+ column);

        Point myMove = new Point(row, column);
        return myMove;
    }

}
