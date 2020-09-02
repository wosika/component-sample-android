package com.wosika.sanya.main.mvi

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.telephony.SignalStrength
import android.telephony.ServiceState
import android.telephony.cdma.CdmaCellLocation
import android.telephony.gsm.GsmCellLocation
import android.telephony.CellLocation
import android.util.Log
import android.net.wifi.WifiManager


object NetworkUtils {


    private val TAG: String = "NetworkUtils"

    @SuppressLint("MissingPermission")
    fun getWifiState(context: Context) {
        val wifiManager: WifiManager =
            context.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager;

       val wifiInfo = wifiManager.connectionInfo
        //获得信号强度值
       val  level = wifiInfo.getRssi()
        //根据获得的信号强度发送信息

        if (level <= 0 && level >= -50) {
            Log.i("NetWorkUtil", "网络：WIFI 网络很好")
        } else if (level < -50 && level >= -70) {
            Log.i("NetWorkUtil", "网络：WIFI 网络不错")
        } else if (level < -70 && level >= -80) {
            Log.i("NetWorkUtil", "网络：WIFI 网络一般")
        } else if (level < -80 && level >= -100) {
            Log.i("NetWorkUtil", "网络：WIFI 网络较差")
        } else {
            Log.i("NetWorkUtil", "网络：WIFI 无网络")
        }

    }


    fun getPhoneState(context: Context) {
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val MyPhoneListener = object : PhoneStateListener() {
            override//获取对应网络的ID，这个方法在这个程序中没什么用处
            fun onCellLocationChanged(location: CellLocation) {
                if (location is GsmCellLocation) {
                    val CID = location.cid
                } else if (location is CdmaCellLocation) {
                    val ID = location.baseStationId
                }


            }

            //系统自带的服务监听器，实时监听网络状态
            override fun onServiceStateChanged(serviceState: ServiceState) {
                super.onServiceStateChanged(serviceState)


            }

            //这个是我们的主角，就是获取对应网络信号强度
            override fun onSignalStrengthsChanged(signalStrength: SignalStrength) {
                //这个ltedbm 是4G信号的值
                val signalinfo = signalStrength.toString()
                val parts =
                    signalinfo.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val ltedbm = Integer.parseInt(parts[9])
                //这个dbm 是2G和3G信号的值
                val asu = signalStrength.gsmSignalStrength
                val dbm = -113 + 2 * asu

                if (telephonyManager.networkType == TelephonyManager.NETWORK_TYPE_LTE) {
                    Log.i("NetWorkUtil", "网络：LTE 信号强度：$ltedbm======Detail:$signalinfo")
                } else if (telephonyManager.networkType == TelephonyManager.NETWORK_TYPE_HSDPA ||
                    telephonyManager.networkType == TelephonyManager.NETWORK_TYPE_HSPA ||
                    telephonyManager.networkType == TelephonyManager.NETWORK_TYPE_HSUPA ||
                    telephonyManager.networkType == TelephonyManager.NETWORK_TYPE_UMTS
                ) {
                    val bin: String
                    if (dbm > -75) {
                        bin = "网络很好"
                    } else if (dbm > -85) {
                        bin = "网络不错"
                    } else if (dbm > -95) {
                        bin = "网络还行"
                    } else if (dbm > -100) {
                        bin = "网络很差"
                    } else {
                        bin = "网络错误"
                    }
                    Log.i("NetWorkUtil", "网络：WCDMA 信号值：$dbm========强度：$bin======Detail:$signalinfo")
                } else {
                    val bin: String
                    if (asu < 0 || asu >= 99)
                        bin = "网络错误"
                    else if (asu >= 16)
                        bin = "网络很好"
                    else if (asu >= 8)
                        bin = "网络不错"
                    else if (asu >= 4)
                        bin = "网络还行"
                    else
                        bin = "网络很差"
                    Log.i("NetWorkUtil", "网络：GSM 信号值：$dbm========强度：$bin======Detail:$signalinfo")
                }

                getWifiState(context)
                super.onSignalStrengthsChanged(signalStrength)
            }
        }
        telephonyManager.listen(MyPhoneListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
    }


}