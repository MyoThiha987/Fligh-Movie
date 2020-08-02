package com.mth.padc_flight_movie.data.dummy

import com.mth.padc_flight_movie.data.vos.DummyVideoVO

fun getSlideImage() : MutableList<DummyVideoVO>{
    var imageList : MutableList<DummyVideoVO> = mutableListOf(
        DummyVideoVO(id=696374,image_path = "https://image.tmdb.org/t/p/original/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg"),
        DummyVideoVO(id=592350,image_path = "https://image.tmdb.org/t/p/original/nH6hPhJq3EEv9CnBZgXU3IQnpJo.jpg"),
        DummyVideoVO(id=19404,image_path = "https://image.tmdb.org/t/p/original/3zCcTOfMfDxFujLxBTFFbD60sDV.jpg"),
        DummyVideoVO(id=278,image_path = "https://image.tmdb.org/t/p/original/cOgNSaguVudRwXi7z0WY9vVDRVe.jpg"),
        DummyVideoVO(id=238,image_path = "https://image.tmdb.org/t/p/original/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg"),
        DummyVideoVO(id=537061,image_path = "https://image.tmdb.org/t/p/original/kwUQFeFXOOpgloMgZaadhzkbTI4.jpg")
    )
    return imageList
}
