package observer.subject;

import observer.observerpattern.IViewer;

public interface IPhotoGallery {
    void subscribe(IViewer viewer);
    void unsubscribe(IViewer viewer);
    void notifyViewers(String update);
}