package Observer_Pattern;
import java.util.ArrayList;
import java.util.List;
interface Observer{
    void update(String userName, String post);
}

class FacebookFollower implements Observer{
    private String followerName;
    public FacebookFollower(String followerName){
        this.followerName = followerName;
    }

    public void update(String userName, String post){
        System.out.println(followerName+" received an update from "+userName+":");
        System.out.println(post);
        System.out.println("===============================");
    }
}

interface Users{
    void registerUser(Observer observer);
    void removeUser(Observer observer);
    void notifyUser(String post);
}

class FacebookUser implements Users{
    private String userName;
    private List<Observer> followers;
    private String latestPost;

    public FacebookUser(String userName){
        this.userName = userName;
        this.followers = new ArrayList<>();
    }

    public void postUpdate(String post){
        latestPost = post;
        notifyUser(post);
    }

    public void registerUser(Observer observer){
        followers.add(observer);
    }

    public void removeUser(Observer observer){
        followers.remove(observer);
    }

    public void notifyUser(String post){
        for(Observer follower:followers){
            follower.update(userName, post);
        }
    }
}

class ObserverPatternDemo{
    public static void main(String[] args) {
        // create user
        FacebookUser alice = new FacebookUser("Alice");
        FacebookUser bob = new FacebookUser("Bob");

        // create follower
        FacebookFollower follower1 = new FacebookFollower("Follower 1");
        FacebookFollower follower2 = new FacebookFollower("Follower 2");

        //registers followers to users
        alice.registerUser(follower1);
        bob.registerUser(follower2);

        // user post update

        alice.postUpdate("This is the main objectives!!!");
        bob.postUpdate("Htid hit man cona do another this!!");
    }
}