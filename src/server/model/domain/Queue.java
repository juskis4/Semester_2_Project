package server.model.domain;

//not worth using queueADT because of limitations

import java.util.ArrayList;

/**
 * A class that represents queue of reservation.
 */
public class Queue {
    private ArrayList<User> users;

    /**
     * A constructor that creates array list of users.
     */
    public Queue(){
        users = new ArrayList<>();
    }

    /**
     * A method that add user to queue.
     * @param user user that is going to be added to queue.
     */
    public void addToQueue(User user){
        users.add(user);
    }

    /**
     * A method that removes first user in the queue from the queue.
     * @return removed user.
     */
    public User removeFirstFromQueue(){
        User tempUser = users.get(0);
        users.remove(0);
        return tempUser;
    }

    /**
     * A method that removes specific user from queue.
     * @param i index of user in a queue.
     * @return removed user.
     */
    public User removeSpecificFromQueue(int i){
        User tempUser = users.get(i);
        users.remove(i);
        return tempUser;
    }

    /**
     * A method that checks if queue is empty.
     * @return
     */
    public boolean isEmpty(){
        if (users.size()>0){
            return false;
        }
        else return true;
    }

    /**
     * A getter for queue size.
     * @return queue size.
     */
    public int queueSize(){
        return users.size();
    }

    /**
     * Getter for all users in the queue.
     * @return users in the queue.
     */
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
