# NegEx Unit Test Documentation

### Overview

This document describes the unit tests and stress tests for the **NegEx library**.
The goal of these tests is to guarantee correct negative indexing behaviour, strict bounds checking, and predictable error signaling for developers using the library.


## Core design principle
* NegEx is loud by design            
* Invalid indexing must fail fast and explain why.  
* No silent null returns or hidden behaviour.

All tests focus on IndexHelper as the source of truth and `NegEx.at(…)` as the public integration layer.

---

## Indexing Model

For an array or list of size N:
*	Valid positive indices: `0 → N - 1`
*	Valid negative indices: `-1 → -N`


| Index | Meaning |
| --- | --- |
| `0` | First element |
| `n - 1` | Last element |
| `-1` | Last element |
| `-n` | First element |

Invalid indices:
* index `>= N`
* index `< -N`

---

## Test Groups

Each test group targets **one responsibility**.
Unit tests verify logic. Integration tests verify behaviour. Stress tests verify resilience.

---

## 1. IndexHelper Tests

### Purpose

Validate index resolution and bound checking logic in isolation.

These tests do not access arrays or lists. They only test index math and validation rules.

### Covered Scenarios

#### Valid Indices
*	Positive index inside bounds
*	Negative index inside bounds
*   Zero index regression
*	Edge negative index `-N`


#### Invalid Indices
*	Positive out-of-bounds `(index == N)`
*	Positive far out-of-bounds
*	Negative out-of-bounds `(index < -N)`
*	Negative far out-of-bounds

Why test IndexHelper directly
•	It is the source of truth for index validation
•	Keeps failures localized
•	Prevents false positives caused by array access

This follows the rule:

**Test logic at the point where it exists**

---

## 2. Error Messaging Tests

### Purpose

#### Ensure that every thrown exception:
*	Is the correct exception type
*	Contains actionable, human-readable feedback

#### Verified Error Conditions
*	Empty array detection
*	Out-of-bounds positive index
*	Out-of-bounds negative index
*	Edge boundary violations

#### Assertions Performed
*	Exception type `(IndexOutOfBoundsException, IllegalStateException)`
*	The message contains:
*	`OUT OF BOUNDS`
*	Array name
*	Array size
*	Suggested valid index

These tests guarantee that error messages are not accidental side effects, but part of the public contract.

---

## 3. NegEx Integration Tests

### Purpose

Verify that the public API correctly delegates to `IndexHelper` and returns correct values.

#### Covered Types
*	Primitive arrays
*	Generic object arrays
*	Lists

#### Scenarios
*	Positive indexing works
*	Negative indexing works
*	Errors propagate unchanged

#### Why integration tests exist
*	Confirms the wiring between API and helper logic
*	Prevents regressions when refactoring internals

---

## 4. Stress Testing

### Purpose

Ensure the library remains correct and stable under extreme usage patterns.

Stress tests **do not** validate the correctness of values. They validate:
*	No crashes
*	No unexpected exceptions
*	No overflow errors

## Stress Strategies Used

#### Repeated Calls
*	Millions of index resolutions
*	Mixed valid and invalid indices

#### Extreme Values
*	`Integer.MIN_VALUE`
*	`Integer.MAX_VALUE`
*	Large negative indices
*	Large positive indices

#### Empty Collections
*	Confirm empty detection always wins
  *	No accidental index math on size `0`

#### Expected Outcomes
*	Exceptions are thrown intentionally
*	No undefined behaviour
*	No performance degradation

---

## Exception Handling Philosophy

Scenario |	Exception |
--- | --- |
Valid index | `null`
Empty array or list	| `IllegalStateException`
Index out of bounds | `IndexOutOfBoundsException`

NegEx intentionally avoids:
*	Returning null
*	Silent failure
*	Clamping values

**If you index wrong, the library tells you immediately.**

---

## Testing Strategy Summary 

Layer  | Exception  | Why |
--- |------------| --
IndexHelper |Yes| Core logic
NegEx.at |Yes|Public API
Error messages|	Yes	|Developer experience
Stress tests|	Yes| Reliability


---

## Final Notes
*	Unit tests protect correctness
*	Integration tests protect behaviour
*	Stress tests protect trust

If any of these fail, the change is unsafe to ship.      
This is intentional.   
NegEx is strict by design.