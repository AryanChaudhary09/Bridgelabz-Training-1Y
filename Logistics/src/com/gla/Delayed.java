package com.gla;
public boolean isDelayed() {
    return actualDuration > expectedDuration;
}

/**
 * Returns how many minutes late the driver was (0 if on time).
 */
public double getDelay() {
    return Math.max(0, actualDuration - expectedDuration);
}

// ── Abstract methods (must be implemented by subclasses) ──
public abstract boolean isCritical();
public abstract String  getType();
public abstract double  calculatePenalty();