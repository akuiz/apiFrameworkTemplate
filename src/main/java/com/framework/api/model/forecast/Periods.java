package com.framework.api.model.forecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Periods {
    private List<Period> periods;

    public static Periods frames1_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-01"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-03", "2018-10-08"),
                        new Period("2018-09-25", "2018-10-05"),
                        new Period("2018-09-25", "2018-10-15")
                ))
                .build();
    }

    public static Periods frames1_2(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10")
                ))
                .build();
    }

    public static Periods frames2_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-03", "2018-10-08"),
                        new Period("2018-09-25", "2018-10-05"),
                        new Period("2018-09-25", "2018-10-15")
                ))
                .build();
    }

    public static Periods frames2_2(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-20"),
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-05", "2018-10-25"),
                        new Period("2018-09-25", "2018-10-15"),
                        new Period("2018-09-25", "2018-10-25")
                ))
                .build();
    }

    public static Periods frames3_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-20"),
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-07", "2018-10-15"),
                        new Period("2018-09-25", "2018-10-10"),
                        new Period("2018-09-25", "2018-10-20")
                ))
                .build();
    }

    public static Periods frames4_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-01"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-07"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-10-05", "2018-10-20"),
                        new Period("2018-09-25", "2018-10-07"),
                        new Period("2018-09-25", "2018-10-20")
                ))
                .build();
    }

    public static Periods frames4_2(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-01"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-07"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-10-05", "2018-10-20"),
                        new Period("2018-09-25", "2018-10-07"),
                        new Period("2018-09-25", "2018-10-20")
                ))
                .build();
    }

    public static Periods frames5_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-25"),
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-10-10", "2018-10-25"),
                        new Period("2018-10-15", "2018-10-20"),
                        new Period("2018-10-15", "2018-10-25"),
                        new Period("2018-09-25", "2018-10-20")
                ))
                .build();
    }

    public static Periods frames5_2(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-25"),
                        new Period("2018-10-01", "2018-10-15"),
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-05", "2018-10-20"),
                        new Period("2018-10-10", "2018-10-15"),
                        new Period("2018-10-10", "2018-10-25"),
                        new Period("2018-10-15", "2018-10-25"),
                        new Period("2018-09-25", "2018-11-02")
                ))
                .build();
    }

    public static Periods frames5_3(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-15"),
                        new Period("2018-10-01", "2018-10-12"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-10", "2018-10-15"),
                        new Period("2018-10-10", "2018-10-20"),
                        new Period("2018-09-25", "2018-10-20")
                ))
                .build();
    }

    public static Periods frames6_1(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-20"),
                        new Period("2018-10-01", "2018-10-10"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-10"),
                        new Period("2018-10-05", "2018-11-02"),
                        new Period("2018-10-10", "2018-10-25"),
                        new Period("2018-10-03", "2018-10-07"),
                        new Period("2018-09-25", "2018-10-15")
                ))
                .build();
    }

    public static Periods frames6_2(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-20"),
                        new Period("2018-10-01", "2018-10-07"),
                        new Period("2018-10-05", "2018-10-15"),
                        new Period("2018-10-07", "2018-10-13"),
                        new Period("2018-10-07", "2018-11-02"),
                        new Period("2018-10-13", "2018-10-20"),
                        new Period("2018-10-20", "2018-11-02"),
                        new Period("2018-09-25", "2018-11-02")
                ))
                .build();
    }

    public static Periods frames6_3(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Period("2018-10-01", "2018-10-20"),
                        new Period("2018-10-01", "2018-10-05"),
                        new Period("2018-10-05", "2018-10-08"),
                        new Period("2018-10-05", "2018-11-02"),
                        new Period("2018-10-08", "2018-10-12"),
                        new Period("2018-10-08", "2018-10-25"),
                        new Period("2018-10-08", "2018-11-12"),
                        new Period("2018-10-12", "2018-10-16"),
                        new Period("2018-10-16", "2018-10-20"),
                        new Period("2018-09-25", "2018-11-02")
                ))
                .build();
    }
}
