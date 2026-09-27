import java.time.LocalDateTime
eff HourOfDay {
    def getCurrentHour(): Int32
}

def greeting(): String \ {HourOfDay} = 
    let h = HourOfDay.getCurrentHour();
    if (h <= 12) 
        "Good morning"
    else if (h <= 18)
        "Good afternoon"
    else 
        "Good evening"

def main(): Unit \ IO = 
    run {
        println(greeting())
    } with handler HourOfDay {
        def getCurrentHour(_, resume) = 
            let dt = LocalDateTime.now();
            resume(dt.getHour())
    }

