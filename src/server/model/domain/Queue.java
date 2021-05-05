package server.model.domain;

//not worth using queueADT because of limitations

import java.util.ArrayList;

public class Queue {
    private ArrayList<User> users;

    public Queue(){
        users = new ArrayList<>();
    }

    public void addToQueue(User user){
        users.add(user);
    }

    public User removeFirstFromQueue(){
        User tempUser = users.get(0);
        users.remove(0);
        return tempUser;
    }

    public User removeSpecificFromQueue(int i){
        User tempUser = users.get(i);
        users.remove(i);
        return tempUser;
    }

    public boolean isEmpty(){
        if (users.size()>0){
            return false;
        }
        else return true;
    }

    public int queueSize(){
        return users.size();
    }

    public ArrayList<User> getAllWaitingUsers(){
        return users;
    }

    /* SINGLETON IF NEEDED

    private static Queue instance;

    private Queue(){
        users = new ArrayList<>();
    }

    public static Queue getInstance(){
        if(instance == null){
            instance = new Queue();
        }
        return instance;
    }

    ////////////////////////////THREAD SAFE/////////////////////////////

    private static Queue instance;
    private static Object lock = new Object();


    private Queue(){
        users = new ArrayList<>();
    }

    public static Queue getInstance(){
        if(instance == null){
            synchronized(lock){
                instance = new Queue();
            }
        }
        return instance;
    }
     */
}
