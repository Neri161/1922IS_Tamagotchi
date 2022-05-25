<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('Tamagotchi', function (Blueprint $table) {
            $table->id();
            $table->integer('codigo');
            $table->string('nombre',100);
            $table->dateTime('ultimo_Banio')->nullable();
            $table->integer('conteo_Banio')->nullable();
            $table->dateTime('ultimo_Enfermo')->nullable();
            $table->integer('conteo_Enfermo')->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        //
    }
};
