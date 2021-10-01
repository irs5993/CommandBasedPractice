// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {  
    public static final int joystick = 0;

    public static class Ports {
        public static class Chasis {
            public static final int left = 9;
            public static final int right = 8;
        }

        public static class Drum {
            public static final int left = 7;
            public static final int right = 6;
        }
    }

    public static class Buttons {
        public static class Chasis {
            public static final int forward = 11;
            public static final int backward = 12;
        }

        public static class Drum {
            public static final int left = 9;
            public static final int right = 10;
        }
    }
}
