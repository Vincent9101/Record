package com.vincent.mvpcustomadvertisement.di.component;

import com.vincent.mvpcustomadvertisement.di.PerActivity;
import com.vincent.mvpcustomadvertisement.di.module.ActivityModule;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementActivity;
import com.vincent.mvpcustomadvertisement.ui.init.InitActivity;
import com.vincent.mvpcustomadvertisement.ui.advertisement.landscape_advertisement.LandscapeAdvertisementFragment;
import com.vincent.mvpcustomadvertisement.ui.advertisement.portrait_advertisement.PortraitAdvertisementFragment;
import dagger.Component;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:53
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(AdvertisementActivity advertisementActivity);

    void inject(LandscapeAdvertisementFragment landscapeAdvertisementFragment);

    void inject(PortraitAdvertisementFragment portraitAdvertisementFragment);

    void inject(InitActivity activity);

}
