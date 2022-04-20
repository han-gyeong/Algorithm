import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // fees 기본시간, 기본 요금, 단위시간, 단위요금
        // records 시간(시간:분), 차량번호, IN/OUT

        // 자동차 번호 저장
        ArrayList<String> cars = new ArrayList<>();

        // 아직 주차장에 있는 차들
        HashMap<String, String> parkingLot = new HashMap<>();

        // 차별 요금 내역
        HashMap<String, Integer> parkingMinute = new HashMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String numberPlate = recordSplit[1];

            if (!cars.contains(numberPlate)) {
                cars.add(numberPlate);
            }

            if (recordSplit[2].equals("IN")) {
                parkingLot.put(numberPlate, recordSplit[0]);
                continue;
            }

            int minute = calMinute(parkingLot.get(numberPlate), recordSplit[0]);
            parkingMinute.put(numberPlate, parkingMinute.getOrDefault(numberPlate, 0) + minute);

            parkingLot.remove(numberPlate);
        }

        parkingLot.forEach((numberPlate, v) -> {
            int minute = calMinute(v, "23:59");
            parkingMinute.put(numberPlate, parkingMinute.getOrDefault(numberPlate, 0) + minute);
        });

        Collections.sort(cars);
        int[] answer = new int[cars.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = calFee(parkingMinute.get(cars.get(i)), fees[0], fees[1], fees[2], fees[3]);
        }

        return answer;
    }

    public int calFee(int minute, int basicMinute, int basicFee, int perMinute, int perFee) {
        if (minute <= basicMinute) {
            return basicFee;
        }

        int overTime = minute - basicMinute;

        if (!(overTime % perMinute == 0)) {
            overTime += (perMinute - (overTime % perMinute));
        }

        int overFee = (overTime / perMinute) * perFee;

        return basicFee + overFee;
    }

    public int calMinute(String from, String to) {
            // to 와 from 사이의 분을 계산
            String[] fromSplit = from.split(":");
            String[] toSplit = to.split(":");

            int fromToMin = Integer.parseInt(fromSplit[0]) * 60 + Integer.parseInt(fromSplit[1]);
            int toToMin = Integer.parseInt(toSplit[0]) * 60 + Integer.parseInt(toSplit[1]);

        return toToMin - fromToMin;
    }
}