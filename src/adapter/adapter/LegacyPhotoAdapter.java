package adapter.adapter;

import adapter.target.IPhotoTarget;
import adapter.adaptee.LegacyPhoto;
import decorator.interfaces.IPhoto;

public class LegacyPhotoAdapter implements IPhotoTarget, IPhoto {
    private LegacyPhoto legacy;

    public LegacyPhotoAdapter(LegacyPhoto legacy) {
        this.legacy = legacy;
    }

    @Override public String getName() { return legacy.getTitle(); }
    @Override public String getDate() { return legacy.getCaptureDate(); }
    @Override public double getRating() { return legacy.getStars(); }
    @Override public String getDescription() { return "Legacy Import: " + legacy.getTitle(); }
}
