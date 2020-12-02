package livraria.Interface;

public interface InSubject {
    boolean attach(InObserver observer);
    boolean detach(InObserver observer);
    void hasChanged();
    void notifyObservers();
}

