class Rom2Arab {
    static int[] intervals = new int[]{0, 1, 4, 5, 9, 10, 40, 50, 90, 100};
    static String[] numerals = new String[]{"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    Rom2Arab() {
    }

    int findFloor(int number, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return firstIndex;
        } else if (intervals[firstIndex] == number) {
            return firstIndex;
        } else if (intervals[lastIndex] == number) {
            return lastIndex;
        } else {
            int median = (lastIndex + firstIndex) / 2;
            if (median == firstIndex) {
                return firstIndex;
            } else if (number == intervals[median]) {
                return median;
            } else {
                return number > intervals[median] ? this.findFloor(number, median, lastIndex) : this.findFloor
                        (number, firstIndex, median);
            }
        }
    }

    String toRom(int number) {
        int floorIndex = this.findFloor(number, 0, intervals.length - 1);
        if (number == intervals[floorIndex]) {
            return numerals[floorIndex];
        } else {
            String var10000 = numerals[floorIndex];
            return var10000 + this.toRom(number - intervals[floorIndex]);
        }
    }

    int toArab(String roman) {
        int result = 0;

        for(int i = intervals.length - 1; i >= 0; --i) {
            while(roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
            }
        }

        return result;
    }
}