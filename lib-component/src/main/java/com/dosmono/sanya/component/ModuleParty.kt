package com.dosmono.sanya.component

/**
 * 通过反射，拿到每个模块的初始化类，对各个模块进行初始化，有新加入的模块都可以在此进行添加
 */
object ModuleParty {

    private const val MAIN_MODULE = "com.dosmono.sanya.main.MainModuleImpl"
    private const val SUB_MODULE = "com.dosmono.sanya.sub.SubModuleImpl"
    private const val TALK_MODULE = "com.dosmono.sanya.talk.TalkModuleImpl"


    val MODULES = arrayOf(MAIN_MODULE, SUB_MODULE, TALK_MODULE)

}