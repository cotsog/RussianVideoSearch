package com.eazyigz.RussiaMediaSearch;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.service.chooser.ChooserTarget;

import java.util.List;

/**
 * Created by Igor on 5/31/2015.
 */
public class ChooserTargetService extends android.service.chooser.ChooserTargetService {
    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName targetActivityName, IntentFilter matchedFilter) {
        return null;
    }
}
