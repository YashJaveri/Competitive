import java.io.*;
import java.util.*;

class Server {
    int id, cap;

    Server(int _id, int _cap) {
        id = _id;
        cap = _cap;
    }
}

class Servers {
    public static void main(String[] args) {
        int N, X;
        List<Server> mServers = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        X = sc.nextInt();
        int cap;

        for (int i = 0; i < N; i++) {
            cap = sc.nextInt();
            Server serv = new Server(i, cap);
            mServers.add(serv);
        }
        Collections.sort(mServers, (s1, s2) -> {
            return s1.cap - s2.cap;
        });

        int occ = 0;
        for (int i = 0; i < N; i++) {
            occ += mServers.get(i).cap;
            System.out.println(occ);
            if (occ >= X)
                break;
            else {
                if (i != 0 && ids.size() != 0) {
                    if (ids.get(i - 1) + 1 == mServers.get(i).id
                            || ids.get(i - 1) - 1 == mServers.get(i).id)
                        ids.add(mServers.get(i).id);
                    else {
                        occ = 0;                        
                        ids.clear();
                    }
                } else if (i == 0 || ids.size() == 0)
                    ids.add(mServers.get(i).id);
            }
        }

        for (int i = 0; i < ids.size(); i++)
            System.out.println(ids.get(i));        
    }
}