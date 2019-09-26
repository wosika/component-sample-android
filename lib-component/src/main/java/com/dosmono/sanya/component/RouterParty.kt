package com.dosmono.sanya.component

object RouterParty {


    const val SERVICE = "/service"

    //宿主 App 组件
    object App {
        private const val APP_GROUP = "/app"

    }

    //main组件
    object Main {
         const val GROUP = "/main"

        const val MAIN_ACTIVITY = "$GROUP/mainactivity"
    }

    // sub组件
    object Sub {
         const val GROUP = "/sub"
        const val SUB_ACTIVITY = "$GROUP/subactivity"
    }


    // talk组件
    object Talk {
        const val GROUP = "/talk"
        const val TALK_ACTIVITY = "$GROUP/talkactivity"
    }


}