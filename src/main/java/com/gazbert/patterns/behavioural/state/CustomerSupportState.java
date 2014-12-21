package com.gazbert.patterns.behavioural.state;

/*The MIT License (MIT)

Copyright (c) 2014 Gazbert

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

/**
 * This is the initial state.
 * 
 * @author gazbert
 *
 */
public class CustomerSupportState implements BugState {

    /** Cost per hour for Customer Support work */
    private static final int HOURLY_RATE = 80;

    /** Reference to the state context */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;

    /**
     * Constructor takes the context as an arg.
     * 
     * @param bugTracker
     */
    public CustomerSupportState(final BugTrackerContext bugTracker)
    {
        this.bugTracker = bugTracker;

        // initilaise this object's internal state
        bugCost = 0;
    }

    public void updateHoursWorked(int hoursWorked) {

        bugCost += (hoursWorked * HOURLY_RATE);
    }

    public int getCost() {	

        return bugCost;	
    }

    @Override
    public void setNextState() {
        bugTracker.setState(bugTracker.getEngineeringState());	// control which state we go to next
    }
}