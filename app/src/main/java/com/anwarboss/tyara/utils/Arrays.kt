package com.anwarboss.tyara.utils

object Arrays {

    val voiceArray = arrayOf("Left engine on fire" //1
            , "Left engine overheat. Reduce left engine"//2
            , "Left engine oil temperature high. Reduce left engine"//3
            , "Left engine oil pressure low. Reduce left engine"//4
            , "Chips in left engine oil. Reduce left engine"//5
            , "Left engine on standby control system. Monitor RPM and EGT"//6
            , "Left engine reheat prohibited"//7
            , "Left engine reheat prohibited"//8
            , "Left engine reheat prohibited"//9
            , "No fuel boost. Switch off reheat"//10
            , "Left engine overspeed. Reduce left engine"//11
            , "Left engine fuel pressure abnormal. Reduce left engine"//12
            , "Left engine fuel pressure abnormal. Reduce left engine"//13
            , "Left engine vibration. Reduce left engine"//14
            , "Left engine overheat. Reduce left engine"//15
            , "Left gearbox vibration"//16
            , "Right gearbox vibration"//17
            , "Left gearbox oil pressure low"//18
            , "Right gearbox oil pressure low"//19
            , "Left gearbox oil temperature high"//20
            , "Right gearbox oil temperature high"//21
            , "Both emergency pump units are in use"//22
            , "Operation from batteries. Watch voltage. Flight time 10 minutes"//23
            , "Both emergency pump units are in use"//24
            , "Left gearbox vibration"//25
            , "Left gearbox oil pressure low"//26
            , "Left gearbox oil temperature high"//27
            , "Air intake screen failure. Mach limit point seven"//28
            , "Left air intake failure"//29
            , "Operation from batteries. Watch voltage. Flight time 10 minutes"//30
            , "Booster hydraulic system failure. Wheels and flaps emergency extension at speed 270 knots"//31
            , "Main hydraulic system failure. Wheels and flaps emergency extension at speed 270 knots"//32
            , "Main hydraulic system failure. Wheels and flaps emergency extension at speed 270 knots"//33
            , "Both emergency pump units are in use"//34
            , "Emergency oxygen switched on – descend"//35
            , "Oxygen system failure"//36
            , "Emergency oxygen switched on – descend"//37
            , "Air data system failure. Refer to ISSI (integrated system standby instrument)"
            , ""//38
            , "Left air intake failure"//39
            , "Right air intake failure"//40
            , "First INS failure"//41
            , "Second INS failure"//42
            , "Both INS failure. Refer to ISSI (integrated system standby instrument)"//43
            , "Main pitot heating off"//43
            , "Refueling pod fire.Switch off refueling pod.Release refueling pod"//44
            , "refueling_pod_failure_switch_on_disconnection_lights"//45
            , "Disconnect"//46
            , ""//47
            , "Check fuel quantity"//48
            , "No Fly-by-Wire redundancy"//49
            , "Alpha sensor failure. Slats fixed"//50
            , "Alpha limiter off. Don’t exceed permitted Alpha and g-load"//51
            , "Fly-by-Wire failure"//52
            , "Fly-by-Wire failure"//53
            , "Autopilot failure"//54
            , "Fly-by-Wire failure"//55
            , "Autopilot failure"//56
            , "Fly-by-Wire failure"//57
            , "Left rudder failure"//58
            , "Right rudder failure"//59
            , "Autopilot failure"//60
            , "Fly-by-Wire failure"//61
            , "Standby pitch channel control"//62
            , "Standby roll channel control"//63
            , "Standby yaw channel control"//64
            , "Autopilot failure"//65
            , "Fly-by-Wire on fixed numbers"//66
            , "Autopilot failure"//67
            , "Fly-by-Wire on fixed numbers. Flight mode"//68
            , "Fly-by-Wire on fixed numbers. Flight mode"//69
            , "Fly-by-Wire on fixed numbers. Landing mode"//70
            , "Autopilot failure"//71
            , "Auto throttle failure"//72
            , "Alpha sensor failure. Slats fixed"//73
            , "Alpha limiter off. Don’t exceed permitted Alpha and g-load"//74
            , "No Fly-by-Wire redundancy"//76
            , "Autopilot failure"//77
            , "Autopilot off. Manual control"//78
            , "No Fly-by-Wire redundancy"//79
            , "Autopilot failure"//80
            , "Auto throttle failure"//81
            , "Stabilizer trimmer failure"//82
            , "Aileron trimmer failure"//83
            , "Rudder trimmer failure"//84
            , "Slats failure. Slats fixed"//85
            , "Slats failure. Flaps emergency extension"//86
            , "Slats failure. Slats fixed"//87
            , "Slats failure. Flaps emergency extension"//88
            , "Control flaps manually"//89
            , "Flaps not extended. Wheels and flaps emergency extension"//90
            , "Flight director control off"//91
            , "Autopilot off. Manual control"//92
            , "Limit signal system failure"//93
            , ""//94
            , ""//95
            , ""//96
            , ""//97
    )

    val photosArray = arrayOf("Pioneers Russia Nov 2016 \n Egypt MAY 2017 \n Hossam Moustafa \n (Air Wing Commander) \n Saleh Moussa (Squadron Commander)\n Khaled Sakr (Pilot)\n Yasser Zaki (Pilot)\n Yasser Hamdy (Pilot)\n Medhat ElSakhawy (Pilot)\n Salah ABO Raya (Pilot)\n Shady Gomaa (Pilot)\n Mohamed ABO Youssif (Pilot)",
            "Pioneers Russia Nov 2016 \n Egypt MAY 2017 \n Hossam Moustafa \n (Air Wing Commander) \n Saleh Moussa (Squadron Commander)\n Khaled Sakr (Pilot)\n Yasser Zaki (Pilot)\n Yasser Hamdy (Pilot)\n Medhat ElSakhawy (Pilot)\n Salah ABO Raya (Pilot)\n Shady Gomaa (Pilot)\n Mohamed ABO Youssif (Pilot)",
            "Pioneers Russia Nov 2016 \n Egypt MAY 2017 \n Hossam Moustafa \n (Air Wing Commander) \n Saleh Moussa (Squadron Commander)\n Khaled Sakr (Pilot)\n Yasser Zaki (Pilot)\n Yasser Hamdy (Pilot)\n Medhat ElSakhawy (Pilot)\n Salah ABO Raya (Pilot)\n Shady Gomaa (Pilot)\n Mohamed ABO Youssif (Pilot)",
            "For the first time in the Egyptian air fource \n Pioneers First Air Refuel Egypt"
            ,"Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President \n EL - SISI Feb 2018",
            "Pioneers First Escort Mission President Vladimir Putin Dec 2017",
            "Tactical Fighting Wing 1.0.4 Geroy")

}