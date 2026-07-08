# Katalon Mobile Visual Automation Framework

Mobile automation testing framework using **Katalon Studio, Appium, Groovy, and OpenCV**.

This project demonstrates Android mobile automation testing with reusable custom keywords and visual regression testing using image comparison.

---

## Tech Stack

- Katalon Studio
- Groovy
- Appium
- Android UI Automation
- OpenCV Image Processing

---

## Key Features

### Mobile Automation

- Android application automation testing
- Element interaction:
  - Tap
  - Input text
  - Verify element
  - Verify text
- Object Repository based locator management

---

### Custom Keyword Framework

Reusable helper functions:

```text
Keywords/helper

├── ImageHelper.groovy
├── VerifyHelper.groovy
├── ScreenshotHelper.groovy
└── TextHelper.groovy
```

---

## Visual Regression Testing

Implemented visual validation using OpenCV.

Flow:

```text
Baseline Image
       |
       v
Capture Mobile Element Screenshot
       |
       v
Actual Image
       |
       v
OpenCV Pixel Comparison
       |
       |
   PASS / FAIL
```

---

## Image Validation Features

- Capture specific mobile element screenshot
- Compare baseline image vs actual image
- Calculate image similarity percentage
- Generate difference image when validation fails
- Threshold based validation


Example Result:

```text
IMAGE DIFFERENCE : 0.0%

IMAGE MATCH : 100.0%
```

---

## Project Structure

```text
Katalon-Mobile-Visual-Framework

├── Test Cases
│
│   └── RENT REVAMP ENV REGRESS
│
├── Object Repository
│
│   └── Mobile Objects
│
├── Keywords
│
│   └── helper
│
│       ├── ImageHelper.groovy
│       ├── VerifyHelper.groovy
│       ├── ScreenshotHelper.groovy
│       └── TextHelper.groovy
│
├── BaselineImages
│
│   └── Expected Images
│
├── ActualImages
│
│   └── Generated During Execution
│
└── DiffImages
    |
    └── Failed Comparison Evidence
```

---

## Sample Test Scenario

### TC-07 Empty Location Validation

Scenario:

```text
1. Open mobile application

2. Navigate to location search page

3. Input invalid location

4. Verify empty state message

5. Capture empty state icon

6. Compare UI image using OpenCV

7. Generate automation result
```

Validation:

```text
Expected Image
      VS
Actual Mobile Screenshot
```

Result:

```text
PASS

IMAGE MATCH : 100%
```

---

## Custom Keyword Example

```groovy
CustomKeywords.'helper.ImageHelper.verifyElementImage'(

    findTestObject('Object Repository/iconEmptyLocation'),

    'BaselineImages/Icon/Outside_area.png',

    5

)
```

---

## Purpose

This project was created as a QA Automation portfolio demonstrating:

- Mobile automation framework design
- Visual regression testing implementation
- Reusable automation architecture
- Custom keyword development
- Image processing validation

---

## Author

QA Automation Engineer Portfolio Project