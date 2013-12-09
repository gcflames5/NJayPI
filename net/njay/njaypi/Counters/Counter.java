package net.njay.njaypi.Counters;

import net.njay.njaypi.Plugin.NJayPI;

import org.bukkit.Bukkit;

/**
 * @author Jordan
 */
public class Counter {
	private Time time = new Time();
	private Time endTime = new Time();
	private boolean isDone = false;
	private boolean hasStarted = false;
	private Runnable whenDone = new Runnable() {@Override public void run() {}};
	private Runnable onTick = new Runnable(){public void run() {}};
	private int Task;
	private boolean isPaused = false;
	private Counter instance = this;
	private CountModes mode = CountModes.COUNTDOWN;
	
	public Counter(CountModes m) {
		this.mode = m; 
	}
	
	public Counter(CountModes m, Time t) {
		if ((whenDone != null)) {
			this.setWhenDone(whenDone);
		}
		if (t != null ) {
			time = t;
		}
	}
	
	public void start() {
		if (!hasStarted) {
			Runnable runThis = null;
			if (this.mode == CountModes.COUNTDOWN) {
				runThis = new Runnable() {
					Counter c = instance;
					@Override
					public void run() {
						if (!c.isPaused) {
							if (this.c.time.tickDown()) {
								c.setFinished(true);
							    c.stop();
							} else {
								System.out.println("trying");
								c.onTick.run();
							}
						}
					}
				};
			} else if (this.mode == CountModes.COUNTER) {
				runThis = new Runnable() {
					Counter c = instance;
					@Override
					public void run() {
						if (!c.isPaused) {
							this.c.time.tickUp();
							c.onTick.run();
						}
					}
				};
			} else if (this.mode == CountModes.COUNTUP) {
				runThis = new Runnable() {
					Counter c = instance;
					@Override
					public void run() {
						if (!c.isPaused) {
							if (c.time.greaterThanOrEqualTo(c.endTime)) {
								c.setFinished(true);
							    c.stop();
							} else {
								this.c.time.tickUp();
								c.onTick.run();
							}
						}
					}
				};
			}
			Task = Bukkit.getScheduler().scheduleSyncRepeatingTask(NJayPI.getPlugin(),runThis, 0, 18);
		} else {
			Bukkit.getLogger().warning("Trying to start an already started Counter");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
		}
		
	}

	private void setFinished(boolean b) {
		isDone = b;
		if(whenDone != null) {
			whenDone.run();
		}
	}
	
	public void stop() {
		if (hasStarted == false) {
			Bukkit.getLogger().warning("Trying to stop a not running Counter");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
			return;
		}
		Bukkit.getScheduler().cancelTask(Task);
		Task = -1;
		whenDone = null;
		hasStarted = false;
	}
	
	public void pause() {
		if (hasStarted == false) {
			Bukkit.getLogger().warning("Trying to pause a not running Counter");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
			return;
		}
		this.isPaused = true;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getTask() {
		return Task;
	}

	public void setTask(int task) {
		Task = task;
	}

	public Runnable getWhenDone() {
		return whenDone;
	}

	public void setWhenDone(Runnable whenDone) {
		this.whenDone = whenDone;
	}


	public CountModes getMode() {
		return mode;
	}

	public void setMode(CountModes mode) {
		Bukkit.getLogger().warning("You can not change the mode of a counter. Please create a new one.");
		for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
	}

	public Runnable getOnTick() {
		return onTick;
	}

	public void setOnTick(Runnable onTick) {
		System.out.println("Being called");
		this.onTick = onTick;
		this.onTick.run();
	}
	
	public Time getTime() {
		return time;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	
}
