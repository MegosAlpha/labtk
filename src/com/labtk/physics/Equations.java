/* 
 * MIT License

 * Copyright (c) 2016 Noah Walker

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.labtk.physics;

/**
 *
 * @author noah
 */
public class Equations {
    public static void GetForce(int mass, int accel) {
        System.out.println(mass*accel);
    }
    
    //Equations for mechanics
    
    //straight movement
    //non-accelerated movement
    public double GetVelocity(double time, double distance){
        return distance / time;
    }
    
    public double GetDistance(double vel, double time){
        return vel*time;
    }
    
    public double GetTime(double vel, double distance){
        return distance / vel;
    }
    
    //accelerated movement
    public double GetVelocityAccel(double time, double accel){
        return time*accel;
    }
    
    public double GetVelocityAccel(double time, double accel, double startVel){
        return GetVelocityAccel(time, accel) + startVel;
    }
    
    public double GetAccel(double time, double vel){
        return vel / time;
    } 
    
    public double GetAccel(double time, double vel, double startVel){
        return GetAccel(time, vel-startVel);
    }
    
    public double GetDistanceAccel(double accel, double time){
        return accel*time*time/2;
    }
    
    public double GetDistanceAccel(double accel, double time, double startVel){
        return GetDistanceAccel(accel, time) + startVel*time;
    }
    
    public double GetTimeAccel(double distance, double accel){
        return Math.sqrt(2*distance/accel);
    }
    
    //others
    public double getEnergy(double mass, double vel){
        return mass*vel*vel/2;
    }
    public static void GetPressure(int force, int area){
        System.out.println(force/area);
    }
}
