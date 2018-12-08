package shyam.ram.advance.room;

import android.content.Context;

public class Access {
    ApplicationDataBase applicationDataBase;

    ApplicationDataBase getInstance(ApplicationDataBase applicationDataBase, Context context) {
        if (applicationDataBase != null) {
            return applicationDataBase;
        }
        return AppDataBase.appDataBaseInstance(context);
    }
}
